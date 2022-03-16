package com.example.popbook.dto

import com.google.gson.annotations.SerializedName

@Suppress("ConstructorParameterNaming")
data class BookListResp(

    @SerializedName("GenreInformation") var GenreInformation: ArrayList<String> = arrayListOf(),
    @SerializedName("Items") var Items: ArrayList<Items> = arrayListOf(),
    @SerializedName("carrier") var carrier: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("first") var first: Int? = null,
    @SerializedName("hits") var hits: Int? = null,
    @SerializedName("last") var last: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("pageCount") var pageCount: Int? = null

)
