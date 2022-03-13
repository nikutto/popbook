package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import kotlin.Suppress

@Controller
class PopbookController(
    @Autowired val rakutenAPIService: RakutenAPIService,
    @Value("rakutenapp.id") val appId: String
) {

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/hello")
    fun hello(): String = "hello"

    @GetMapping("/test")
    fun test(model: Model): String {
        val tmp = rakutenAPIService.listBooks(appId).execute()
        model["msg1"] = tmp.code()
        // model["msg2"] = tmp.body()
        return "test"
    }
}
