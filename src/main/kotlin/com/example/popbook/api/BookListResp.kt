package com.example.popbook.api

import com.google.gson.annotations.SerializedName

data class BookListResp(

    @SerializedName("GenreInformation") var genreInformation: ArrayList<String> = arrayListOf(),
    @SerializedName("Items") var items: ArrayList<ItemWrapper> = arrayListOf(),
    @SerializedName("carrier") var carrier: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("first") var first: Int? = null,
    @SerializedName("hits") var hits: Int? = null,
    @SerializedName("last") var last: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("pageCount") var pageCount: Int? = null

)
