package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MockAPITest(
    @Autowired val testRakutenAPIService: RakutenAPIService
) {

    @Test
    fun mockTest() {
        testRakutenAPIService
            .listBooks("APP_ID", 1)
            .execute()
            .body()!!
    }
}
