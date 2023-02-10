package com.example.testappwithmvvm.data.network

import com.example.testappwithmvvm.data.response.LoginResponse
import retrofit2.http.GET

interface UserApi : BaseApi{
    @GET("user")
    suspend fun getUser(): LoginResponse
}