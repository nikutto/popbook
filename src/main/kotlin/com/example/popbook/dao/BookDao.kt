package com.example.popbook.dao

import com.example.popbook.dto.BookDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "book")
class BookDao(
    @Id
    @SequenceGenerator(name = "book_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val author: String,
    val itemUrl: String,
    val imageUrl: String,
    val createdAt: LocalDateTime
) {
    companion object {
        val DF = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm")
    }
    fun toDto() =
        BookDto(
            title = title,
            author = author,
            itemUrl = itemUrl,
            imageUrl = imageUrl,
            booksGenreId = null,
            createdAt = DF.format(createdAt)
        )
}
