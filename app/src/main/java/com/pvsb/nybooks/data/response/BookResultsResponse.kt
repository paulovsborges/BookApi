package com.pvsb.nybooks.data.response

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class BookResultsResponse(

  
    @SerializedName("book_details")
    val bookDetailResponses: List<BookDetailsResponse>


)
