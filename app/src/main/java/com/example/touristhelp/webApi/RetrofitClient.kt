package com.example.touristhelp.webApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//  http://05b054f7086e.ngrok.io/car_rental/index.php

object RetrofitClient {
    private const val base_url = "http://05b054f7086e.ngrok.io/"

    val instance : Api by lazy {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitBuilder.create(Api::class.java)
    }
}