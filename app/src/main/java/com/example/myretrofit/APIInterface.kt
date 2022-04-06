package com.example.myretrofit

import retrofit2.http.GET


interface APIInterface {
    @GET("/api/users?page=2")
    fun doGetListResources(): retrofit2.Call<MultipleResource?>?
}