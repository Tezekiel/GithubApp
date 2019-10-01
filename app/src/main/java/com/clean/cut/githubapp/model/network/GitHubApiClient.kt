package com.clean.cut.githubapp.model.network


import com.clean.cut.githubapp.data.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiClient {

    @GET("repositories")
    suspend fun searchQuery(@Query(value = "q") query: String): SearchResult

}