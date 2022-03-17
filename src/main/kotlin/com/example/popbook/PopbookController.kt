package com.example.popbook

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import kotlin.Suppress

@Controller
class PopbookController(
    @Autowired val popbookService: PopbookService
) {

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/hello")
    fun hello(): String = "hello"

    @Suppress
    @PostMapping("/update")
    fun update(model: Model): String {
        popbookService.update()
        return debug(model)
    }

    @Suppress
    @GetMapping("/")
    fun popbook(model: Model): String {
        model["books"] = popbookService.listPopbooks()
        return "list"
    }

    @Suppress
    @GetMapping("/debug")
    fun debug(model: Model): String {
        val msg = popbookService.debug()
        model["msg"] = "Book list is updated in $msg minutes."
        model["books"] = popbookService.listAll()
        return "debug"
    }
}
