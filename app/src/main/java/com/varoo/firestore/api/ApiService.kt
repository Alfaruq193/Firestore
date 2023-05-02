package com.varoo.firestore.api

import com.varoo.firestore.model.ResponseUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("regis")
    fun registrasi(
        @Field("name")  name: String,
        @Field("email")  email: String,
        @Field("password")  password: String
    ): Call<ResponseUser>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email")  email: String,
        @Field("password")  password: String
    ): Call<ResponseUser>



}