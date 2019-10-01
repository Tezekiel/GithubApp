package com.clean.cut.githubapp.model.network

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object WebAccess {
    val githubApi : GitHubApiClient by lazy {
        val retrofit = Retrofit.Builder()

            .baseUrl("https://api.github.com/search/")
            // Moshi maps JSON to classes
            .addConverterFactory(MoshiConverterFactory.create())//.asLenient())TODO as lenient dodan
            //.addConverterFactory(ScalarsConverterFactory.create()) // za debugging
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        Log.v("primjer", "git api")

        return@lazy retrofit.create(GitHubApiClient::class.java)
    }
}