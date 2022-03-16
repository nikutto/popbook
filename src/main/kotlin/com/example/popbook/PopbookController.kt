package com.example.popbook

import com.example.popbook.dao.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import kotlin.Suppress

@Controller
class PopbookController(
    @Autowired val popbookService: PopbookService
) {

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/hello")
    fun hello(): String = "hello"

    private fun render(model: Model, books: List<Book>): String {
        model["books"] = books
        return "test"
    }

    @GetMapping("/test")
    fun test(model: Model): String {
        val books = popbookService.listAll()
        return render(model, books)
    }

    @Suppress
    @GetMapping("/update")
    fun update(model: Model): String {
        popbookService.update()
        return test(model)
    }

    @Suppress
    @GetMapping("/popbook")
    fun popbook(model: Model): String {
        val books = popbookService.listPopbooks()
        return render(model, books)
    }

    @Suppress
    @GetMapping("/debug")
    fun debug(model: Model): String {
        val msg = popbookService.debug()
        model["msg"] = msg
        return "debug"
    }
}
