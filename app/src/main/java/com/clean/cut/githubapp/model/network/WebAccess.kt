package com.clean.cut.githubapp.model.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

// Singleton pattern in Kotlin: https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
object WebAccess {
    val githubApi : GitHubApiClient by lazy {
        val retrofit = Retrofit.Builder()

            .baseUrl("https://api.github.com/search/")
            // Moshi maps JSON to classes
            //.addConverterFactory(MoshiConverterFactory.create().asLenient())//TODO as lenient dodan
            .addConverterFactory(ScalarsConverterFactory.create()) // za debugging
            // The call adapter handles threads
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        // Create Retrofit client
        return@lazy retrofit.create(GitHubApiClient::class.java)
    }
}