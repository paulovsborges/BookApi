package com.pvsb.nybooks.data.response

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class BookResultsResponse(

   // @Json(name = "book_details")
    @SerializedName("book_details")
    val bookDetailResponses: List<BookDetailsResponse>


)