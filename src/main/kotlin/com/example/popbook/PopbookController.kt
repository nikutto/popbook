package com.example.popbook

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import kotlin.Suppress

@Controller
class PopbookController {

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/")
    fun hello(): String = "hello"
}
