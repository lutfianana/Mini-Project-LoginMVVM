package com.example.testappwithmvvm.data.network

import com.example.testappwithmvvm.data.response.TokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TokenRefreshApi : BaseApi {
    @FormUrlEncoded
    @POST("auth/token")
    suspend fun refreshAccessToken(
        @Field("token") refreshToken: String?
    ): TokenResponse
}