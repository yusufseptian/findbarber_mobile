package com.example.findbarber.`interface`

import com.example.findbarber.model.ApiBarber
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiBarber {
    @GET("apibarber")
    fun findAll(

    ): Call<List<ApiBarber>>

    @POST("apibarber/searchbarber")
    @FormUrlEncoded
    fun searchBarber(
        @Field("key") key : String,
    ): Call<List<ApiBarber>>
}