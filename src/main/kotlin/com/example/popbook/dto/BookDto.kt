package com.example.popbook.dto

import com.example.popbook.dao.Book
import java.time.LocalDateTime

data class BookDto(
    val title: String,
    val author: String,
    val itemUrl: String,
    val imageUrl: String,
    val booksGenreId: String?,
    val createdAt: String
) {
    fun isNotComic() = booksGenreId == null || !booksGenreId.startsWith("001001")

    fun toDao(createdAt: LocalDateTime) = Book(
        id = null,
        title,
        author,
        itemUrl,
        imageUrl,
        createdAt = createdAt,
    )
}
