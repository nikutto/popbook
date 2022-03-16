package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MockAPITest(
    @Autowired val testRakutenAPIService: RakutenAPIService
) {

    @Test
    fun mockTest() {
        val msg = testRakutenAPIService
            .listBooks("APP_ID")
            .execute()
            .body()!!
            .string()
        assertEquals("msg", msg)
    }
}
