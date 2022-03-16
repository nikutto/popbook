package com.example.popbook.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class RakutenAPIServiceConfiguration {

    @Bean
    fun rakutenAPIService(): RakutenAPIService {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://app.rakuten.co.jp/services/api/")
            .build()

        return retrofit.create(RakutenAPIService::class.java)
    }
}
