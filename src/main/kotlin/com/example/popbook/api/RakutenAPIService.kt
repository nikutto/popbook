package com.example.popbook.api

import com.example.popbook.dto.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@Component
class RakutenAPIService(
    @Autowired private val rakutenAPIServiceImpl: RakutenAPIServiceImpl,
) {

    fun listBooks(page: Int): List<BookDto> {
        val appId = System.getenv("APP_ID")!!
        val resp = rakutenAPIServiceImpl.listBooks(appId, page).execute().body()!!
        return resp
            .Items
            .map { it.Item }
            .filterNotNull()
            .filter(Item::isValidItem)
            .map(Item::toDto)
            .toList()
    }
}

@Component
interface RakutenAPIServiceImpl {
    @GET("BooksBook/Search/20170404?format=json&sort=sales&hits=25")
    fun listBooks(@Query("applicationId") appId: String, @Query("page") page: Int): Call<BookListResp>
}
