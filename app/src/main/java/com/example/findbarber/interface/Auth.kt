package com.example.findbarber.`interface`

import com.example.findbarber.model.Login
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Auth {
    @POST("auth/login")
    @FormUrlEncoded
    fun login(
        @Field("us_username") us_username : String,
        @Field("us_password") us_password : String
    ): Call<Login>

    @POST("auth/register")
    @FormUrlEncoded
    fun register(
        @Field("us_username") us_username : String,
        @Field("us_password") us_password : String
    ): Call<Login>
}