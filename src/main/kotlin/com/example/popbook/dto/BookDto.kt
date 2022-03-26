package com.example.popbook.dto

data class BookDto(
    val title: String,
    val author: String,
    val itemUrl: String,
    val imageUrl: String,
    val booksGenreId: String?,
    val createdAt: String
) {
    fun isNotComic() = booksGenreId == null || !booksGenreId.startsWith("001001")
}
