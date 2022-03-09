package com.example.popbook

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PopbookController {

    @GetMapping("/")
    fun hello(model: Model): String = "hello"

}