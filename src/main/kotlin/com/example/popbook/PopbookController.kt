package com.example.popbook

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PopbookController(
    @Autowired val popbookService: PopbookService
) {

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
        model["books"] = popbookService.listPopbooks()
        return "list"
    }

    @GetMapping("/debug")
    fun debug(model: Model): String {
        val msg = popbookService.debug()
        model["msg"] = "Book list is updated in $msg minutes."
        model["books"] = popbookService.listAll()
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
        model["books"] = popbookService.listLatest()
        return "latest"
    }
}
