package com.pvsb.nybooks.data.response

import com.google.gson.annotations.SerializedName

data class BookResultsResponse(

    @SerializedName("book_details")
    val bookDetailResponses: List<BookDetailsResponse>
)