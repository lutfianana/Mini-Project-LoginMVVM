package com.example.testappwithmvvm.data.repository

import com.example.testappwithmvvm.data.network.UserApi
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val api: UserApi
) : BaseRepository(api) {

    suspend fun getUser() = safeApiCall { api.getUser() }

}