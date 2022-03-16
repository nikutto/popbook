package com.example.popbook

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

    @GetMapping("/test")
    fun test(model: Model): String {
        val books = popbookService.listAll()
        model["books"] = books
        return "test"
    }

    @Suppress
    fun update(model: Model): String {
        popbookService.update()
        return test(model)
    }
}
