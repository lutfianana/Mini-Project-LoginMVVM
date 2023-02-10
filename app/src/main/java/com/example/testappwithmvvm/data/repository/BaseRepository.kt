package com.example.testappwithmvvm.data.repository

import com.example.testappwithmvvm.data.network.BaseApi
import com.example.testappwithmvvm.data.network.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {

    suspend fun logout() = safeApiCall {
        api.logout()
    }
}