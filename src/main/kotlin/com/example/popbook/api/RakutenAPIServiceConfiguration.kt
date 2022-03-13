package com.example.popbook.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit

@Configuration
class RakutenAPIServiceConfiguration {

    @Bean
    fun rakutenAPIService(): RakutenAPIService {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://app.rakuten.co.jp/services/api/")
            .build()

        return retrofit.create(RakutenAPIService::class.java)
    }
}
