package com.example.popbook

import com.example.popbook.dao.Book
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.Date

@SpringBootTest
class BookRepositoryTest(
    @Autowired val bookRepository: BookRepository
) {

    @Test
    fun saveTest() {
        val book = Book(
            id = null,
            title = "Unti",
            author = "Oshiri",
            itemUrl = "https://unti.com/item",
            imageUrl = "https://unti.com/image",
            createdAt = Date(),
        )
        bookRepository.save(book)
    }
}
