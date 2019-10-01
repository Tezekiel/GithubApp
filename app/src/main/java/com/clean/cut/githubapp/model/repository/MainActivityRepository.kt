package com.clean.cut.githubapp.model.repository

import android.util.Log
import com.clean.cut.githubapp.data.SearchResult
import com.clean.cut.githubapp.model.network.GitHubApiClient
import com.clean.cut.githubapp.model.network.WebAccess

class MainActivityRepository{
    var client: GitHubApiClient = WebAccess.githubApi

    suspend fun searchGithub(search: String): SearchResult {
        Log.v("primjer", "repos")
        return client.searchQuery(search)
    }

}