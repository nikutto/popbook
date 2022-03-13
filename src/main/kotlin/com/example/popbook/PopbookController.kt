package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import kotlin.Suppress

@Controller
class PopbookController(
    @Autowired val rakutenAPIService: RakutenAPIService
) {

    @Suppress("FunctionOnlyReturningConstant")
    @GetMapping("/hello")
    fun hello(): String = "hello"

    @GetMapping("/test")
    fun test(model: Model): String {
        val appId = System.getenv("APP_ID")!!
        val tmp = rakutenAPIService.listBooks(appId).execute()
        model["msg1"] = tmp.body()!!.string()
        // model["msg2"] = appId
        return "test"
    }
}
