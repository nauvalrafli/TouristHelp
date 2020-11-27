package com.example.touristhelp.webApi

import com.example.touristhelp.car.Car
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//  http://05b054f7086e.ngrok.io/car_rental/index.php

interface Api {
    @GET("car_rental/api_read.php")
    fun getApi() : Call<ArrayList<Car>>

    @FormUrlEncoded
    @POST("car_rental/api_update.php")
    fun postApi(
            @Field("fname")name : String,
            @Field("id_no")id : String,
            @Field("gender")gender : String,
            @Field("email")email : String,
            @Field("phone")phone : String,
            @Field("location")location : String,
            @Field("car_id") car_id : String
    ): Call<postCar>
    //pake Call dari retrofit2
}