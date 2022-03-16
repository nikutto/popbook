package com.example.popbook

import com.example.popbook.api.RakutenAPIService
import io.mockk.every
import io.mockk.mockk
import okhttp3.ResponseBody
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Call
import retrofit2.Response

@Configuration
class MockConfiguration {

    @Bean
    fun testRakutenAPIService(): RakutenAPIService {
        val respBody = mockk<ResponseBody>()
        val resp = mockk<Response<ResponseBody>>()
        val callee: Call<ResponseBody> = mockk()
        val service: RakutenAPIService = mockk()

        every { respBody.string() } returns "msg"
        every { resp.body() } returns respBody
        every { callee.execute() } returns resp
        every { service.listBooks(any()) } returns callee

        return service
    }
}
