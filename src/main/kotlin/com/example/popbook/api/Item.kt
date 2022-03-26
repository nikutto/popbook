package com.example.popbook.api

import com.example.popbook.dto.BookDto
import com.google.gson.annotations.SerializedName

data class Item(

    @SerializedName("affiliateUrl") var affiliateUrl: String? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("authorKana") var authorKana: String? = null,
    @SerializedName("availability") var availability: String? = null,
    @SerializedName("booksGenreId") var booksGenreId: String? = null,
    @SerializedName("chirayomiUrl") var chirayomiUrl: String? = null,
    @SerializedName("contents") var contents: String? = null,
    @SerializedName("discountPrice") var discountPrice: Int? = null,
    @SerializedName("discountRate") var discountRate: Int? = null,
    @SerializedName("isbn") var isbn: String? = null,
    @SerializedName("itemCaption") var itemCaption: String? = null,
    @SerializedName("itemPrice") var itemPrice: Int? = null,
    @SerializedName("itemUrl") var itemUrl: String? = null,
    @SerializedName("largeImageUrl") var largeImageUrl: String? = null,
    @SerializedName("limitedFlag") var limitedFlag: Int? = null,
    @SerializedName("listPrice") var listPrice: Int? = null,
    @SerializedName("mediumImageUrl") var mediumImageUrl: String? = null,
    @SerializedName("postageFlag") var postageFlag: Int? = null,
    @SerializedName("publisherName") var publisherName: String? = null,
    @SerializedName("reviewAverage") var reviewAverage: String? = null,
    @SerializedName("reviewCount") var reviewCount: Int? = null,
    @SerializedName("salesDate") var salesDate: String? = null,
    @SerializedName("seriesName") var seriesName: String? = null,
    @SerializedName("seriesNameKana") var seriesNameKana: String? = null,
    @SerializedName("size") var size: String? = null,
    @SerializedName("smallImageUrl") var smallImageUrl: String? = null,
    @SerializedName("subTitle") var subTitle: String? = null,
    @SerializedName("subTitleKana") var subTitleKana: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("titleKana") var titleKana: String? = null
) {

    fun isValidItem() = title != null &&
        author != null &&
        itemUrl != null &&
        mediumImageUrl != null

    fun toDto(): BookDto {
        assert(isValidItem())
        return BookDto(
            title!!,
            author!!,
            itemUrl!!,
            imageUrl = mediumImageUrl!!,
            booksGenreId = booksGenreId,
            createdAt = ""
        )
    }
}

@Suppress("ConstructorParameterNaming")
data class ItemWrapper(
    @SerializedName("Item") var Item: Item? = Item()

)
