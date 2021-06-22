package com.pvsb.nybooks.data

import com.pvsb.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {

    //endPoints da Api NyBooks
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "xq02QtryvYT4SWLiIqqLHUvH0CeXp7xT",
        @Query("list") list: String = "hardcover-fiction"

    ) : Call<BookBodyResponse>

}