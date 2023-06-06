package com.foodtracker.app.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val retrofit: ApiFoodtracker = Retrofit.Builder()
        .baseUrl("http://192.168.1.101:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiFoodtracker::class.java)
}




