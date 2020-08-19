package com.example.gui

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("1")
    fun getJSON(): Call<Model?>?
}