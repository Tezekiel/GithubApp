package com.clean.cut.githubapp.model.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object WebAccess {
    val githubApi : GitHubApiClient by lazy {
        val retrofit = Retrofit.Builder()

            .baseUrl("https://api.github.com/search/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return@lazy retrofit.create(GitHubApiClient::class.java)
    }
}