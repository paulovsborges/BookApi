package com.pvsb.nybooks.data.api

import com.pvsb.nybooks.data.response.BookBodyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTApi {

    @GET("lists.json")
    suspend fun getBooks(
        @Query("api-key") apiKey: String  = "xq02QtryvYT4SWLiIqqLHUvH0CeXp7xT" ,
        @Query("list") list: String = "hardcover-fiction"
    ) : BookBodyResponse
}