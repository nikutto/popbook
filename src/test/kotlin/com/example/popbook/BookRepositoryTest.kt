package com.example.popbook

import com.example.popbook.dao.BookDao
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class BookRepositoryTest(
    @Autowired val bookRepository: BookRepository
) {

    @Test
    fun saveTest() {
        val book = BookDao(
            id = null,
            title = "Unti",
            author = "Oshiri",
            itemUrl = "https://unti.com/item",
            imageUrl = "https://unti.com/image",
            createdAt = LocalDateTime.now(),
        )
        bookRepository.save(book)
    }
}
