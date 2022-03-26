package com.example.popbook

import com.example.popbook.dao.BookDao
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<BookDao, Long> {
    fun save(book: BookDao): Unit
    override fun findAll(): List<BookDao>
}
