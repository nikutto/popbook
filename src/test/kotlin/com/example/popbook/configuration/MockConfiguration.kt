package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import com.example.popbook.dto.BookListResp
import io.mockk.every
import io.mockk.mockk
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Call
import retrofit2.Response

@Configuration
class MockConfiguration {

    val emptyBookListResp = BookListResp()

    @Bean
    fun testRakutenAPIService(): RakutenAPIService {
        val resp = mockk<Response<BookListResp>>()
        val callee: Call<BookListResp> = mockk()
        val service: RakutenAPIService = mockk()

        every { resp.body() } returns BookListResp()
        every { callee.execute() } returns resp
        every { service.listBooks(any()) } returns callee

        return service
    }
}
