package com.pvsb.nybooks.data.response

import com.google.gson.annotations.SerializedName
import com.pvsb.nybooks.data.model.Book
import com.squareup.moshi.Json


data class BookDetailsResponse(

    /**
     * se o nome do atributo for o mesmo nome no objeto da Api, a ferramenta vai entender que estes
     * campos são equivalente, tornando a anotação do @SerializedName(name = "") desnecessária
     * */

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