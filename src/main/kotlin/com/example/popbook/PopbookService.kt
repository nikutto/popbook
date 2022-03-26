package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import com.example.popbook.dao.BookDao
import com.example.popbook.dto.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

@Service
class PopbookService(
    @Autowired val bookRepository: BookRepository,
    @Autowired val rakutenAPIService: RakutenAPIService,
    @Autowired val serviceConfiguration: ServiceConfiguration
) {

    fun listAll() = bookRepository.findAll().toList()

    companion object {

        private fun getNow() = LocalDateTime.now(ZoneId.of("Asia/Tokyo"))
    }

    private fun insertUpdate() {
        val now = getNow()
        var cnt = 0
        for (i in 1..serviceConfiguration.nPage) {
            if (i != 1) {
                Thread.sleep(1)
            }
            val books = rakutenAPIService
                .listBooks(i)
                .filter {
                    it.isNotComic()
                }.map {
                    it.toDao(now)
                }.toList()
            for (book in books) {
                bookRepository.save(book)
                cnt += 1
                if (cnt >= serviceConfiguration.nMaxInsert) {
                    return
                }
            }
        }
    }

    private fun deleteUpdate() {
        val books: List<BookDao> = bookRepository.findAll()
        val now = getNow()
        for (book in books) {
            val diffHours = ChronoUnit.HOURS.between(book.createdAt, now)
            if (diffHours >= serviceConfiguration.expireHours) {
                bookRepository.delete(book)
            }
        }
    }

    private fun isRecentlyUpdated(): Boolean {
        val books: List<BookDao> = bookRepository.findAll()
        val now = getNow()
        if (books.isEmpty()) return false
        val previousUpdateHours = ChronoUnit.MINUTES.between(
            books.map { it.createdAt }.maxOrNull()!!,
            now
        )
        return previousUpdateHours < serviceConfiguration.updateIntervalMinutes
    }

    fun update() {
        if (!isRecentlyUpdated()) {
            insertUpdate()
        }
        deleteUpdate()
    }

    fun listPopbooks(): List<BookDto> {
        val books = listAll()
        val titles = books.map { it.title }.distinct()
        val now = getNow()

        val isNewTitle = { title: String ->
            books.filter { title == it.title }
                .map { it.createdAt }
                .all {
                    ChronoUnit.HOURS.between(
                        it,
                        now
                    ) <= serviceConfiguration.poppingHours
                }
        }

        return titles.filter(isNewTitle)
            .map {
                title ->
                books.filter {
                    it.title == title
                }.minByOrNull {
                    it.createdAt
                }!!
            }.sortedBy {
                it.createdAt
            }.reversed()
            .map(BookDao::toDto)
            .toList()
    }

    fun debug(): Long {
        val books: List<BookDao> = bookRepository.findAll()
        val now = getNow()
        return ChronoUnit.MINUTES.between(
            books.map { it.createdAt }.maxOrNull()!!,
            now
        )
    }

    fun listLatest(): List<BookDto> {
        val books = bookRepository.findAll()
        val latest = books.map { it.createdAt }.maxOrNull()!!
        return books.filter { it.createdAt == latest }.map(BookDao::toDto).toList()
    }
}
