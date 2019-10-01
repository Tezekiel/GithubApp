package com.clean.cut.githubapp.model.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiClient {

    @GET("repositories")
    suspend fun searchQuery(@Query(value = "q") query: String): String

}