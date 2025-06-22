package com.example.composeintro.ComposeRetfrofit.service

import com.example.composeintro.ComposeRetfrofit.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}