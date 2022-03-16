package com.example.popbook

import com.example.popbook.dao.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long> {
    fun save(book: Book): Unit
}
