package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import io.mockk.every
import io.mockk.mockk
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MockConfiguration {

    @Bean
    fun testRakutenAPIService(): RakutenAPIService {
        val service: RakutenAPIService = mockk()
        every { service.listBooks(any()) } returns listOf()

        return service
    }
}
