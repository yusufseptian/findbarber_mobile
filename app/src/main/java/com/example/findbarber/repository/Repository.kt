package com.example.findbarber.repository

import com.example.findbarber.`interface`.Auth
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repository {
    val gson = GsonBuilder().setLenient().create()
    val baseUrl = "http://192.168.8.180/brotherbengkel/public/"
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun auth() : Auth{
        return retrofit.create(Auth::class.java)
    }

}