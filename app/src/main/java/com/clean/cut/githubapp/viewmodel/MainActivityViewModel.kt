package com.clean.cut.githubapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.cut.githubapp.data.SearchResult
import com.clean.cut.githubapp.model.repository.MainActivityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private val repository: MainActivityRepository = MainActivityRepository()
    val liveData = MutableLiveData<SearchResult>()

    var queryText = ""
    var isLoading = false

    fun getSearchData(){
        if(queryText.isNotEmpty()) {
            isLoading = true
            viewModelScope.launch {
                val searchData = withContext(Dispatchers.IO) {
                    repository.searchGithub(queryText)
                }
                isLoading = false
                liveData.value = searchData
            }
        }
    }

}