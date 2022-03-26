package com.example.popbook

import com.example.popbook.dao.Book
import com.example.popbook.dto.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.time.format.DateTimeFormatter

@Controller
class PopbookController(
    @Autowired val popbookService: PopbookService
) {
    companion object {
        private fun toDtos(books: List<Book>): List<BookDto> {
            val df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm")
            return books.map {
                BookDto(
                    title = it.title,
                    author = it.author,
                    itemUrl = it.itemUrl,
                    imageUrl = it.imageUrl,
                    booksGenreId = null,
                    createdAt = df.format(it.createdAt!!)
                )
            }
        }
    }

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/hello")
    fun hello(): String = "hello"

    @PostMapping("/update")
    fun update(model: Model): String {
        popbookService.update()
        return debug(model)
    }

    @GetMapping("/")
    fun popbook(model: Model): String {
        model["books"] = toDtos(popbookService.listPopbooks())
        return "list"
    }

    @GetMapping("/debug")
    fun debug(model: Model): String {
        val msg = popbookService.debug()
        model["msg"] = "Book list is updated in $msg minutes."
        model["books"] = toDtos(popbookService.listAll())
        return "debug"
    }

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/about")
    fun about() = "about"

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/contact")
    fun contact() = "contact"

    @GetMapping("/latest")
    fun latest(model: Model): String {
        model["books"] = toDtos(popbookService.listLatest())
        return "latest"
    }
}
