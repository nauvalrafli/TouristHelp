package com.example.touristhelp.webApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//  http://17ba1752995f.ngrok.io/car_rental/index.php

object RetrofitClient {
    private const val base_url = "http://17ba1752995f.ngrok.io/"

    val instance : Api by lazy {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitBuilder.create(Api::class.java)
    }
}