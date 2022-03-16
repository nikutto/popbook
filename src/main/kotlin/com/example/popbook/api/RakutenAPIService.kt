package com.example.popbook.api

import com.example.popbook.dto.BookListResp
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@Component
interface RakutenAPIService {

    @GET("BooksBook/Search/20170404?format=json&sort=sales")
    fun listBooks(@Query("applicationId") appId: String): Call<BookListResp>
}
