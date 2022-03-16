package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import com.example.popbook.dao.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Service
class PopbookService(
    @Autowired val bookRepository: BookRepository,
    @Autowired val rakutenAPIService: RakutenAPIService
) {

    fun listAll(): List<Book> {
        return bookRepository.findAll().toList()
    }

    @Suppress("UnusedPrivateMember", "ComplexCondition")
    private fun insertUpdate() {
        val appId = System.getenv("APP_ID")!!
        val books = rakutenAPIService.listBooks(appId).execute().body()!!
        val items = books.Items
        for (elem in items) {
            val item = elem.Item
            if (item != null &&
                item.title != null &&
                item.author != null &&
                item.itemUrl != null &&
                item.mediumImageUrl != null
            ) {
                val book = Book(
                    null,
                    item.title!!,
                    item.author!!,
                    item.itemUrl!!,
                    item.mediumImageUrl!!,
                    LocalDateTime.now()
                )
                bookRepository.save(book)
            }
        }
    }

    @Suppress("EmptyFunctionBlock")
    private fun deleteUpdate() {
    }

    @Suppress("MagicNumber")
    private fun isRecentlyUpdated(): Boolean {
        val books: List<Book> = bookRepository.findAll()
        val now = LocalDateTime.now()
        return books.isEmpty() ||
            ChronoUnit.MINUTES.between(
            books.map { it.createdAt!! }.maxOrNull()!!,
            now
        ) < 60
    }

    fun update() {
        if (!isRecentlyUpdated()) {
            insertUpdate()
        }
        deleteUpdate()
    }

    fun listPopbooks(): List<Book> {
        val books = listAll()
        val ans: MutableList<Book> = mutableListOf()
        val s = mutableSetOf<String>()
        for (book in books) {
            if (!s.add(book.title)) {
                continue
            }
            val now = LocalDateTime.now()
            val isNew = books.filter { it.title == book.title }
                .map { it.createdAt!! }
                .all {
                    ChronoUnit.DAYS.between(
                        it,
                        now
                    ) <= 1
                }
            if (isNew) {
                ans.add(book)
            }
        }
        return ans.toList()
    }

    fun debug(): Long {
        val books: List<Book> = bookRepository.findAll()
        val now = LocalDateTime.now()
        return ChronoUnit.MINUTES.between(
            books.map { it.createdAt!! }.maxOrNull()!!,
            now
        )
    }
}