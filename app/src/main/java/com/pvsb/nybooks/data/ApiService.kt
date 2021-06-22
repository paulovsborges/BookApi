package com.pvsb.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiService {


    //instancia do retrofit
    private fun initRetrofit(): Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: NYTServices = initRetrofit().create(NYTServices::class.java)

}