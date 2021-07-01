package com.pvsb.nybooks.data.response

import com.google.gson.annotations.SerializedName
import com.pvsb.nybooks.model.Book

data class BookDetailsResponse(

    @SerializedName("title")
    val title: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("description")
    val description: String

) {
    fun getBookModel() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}