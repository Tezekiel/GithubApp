package com.clean.cut.githubapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clean.cut.githubapp.R
import com.clean.cut.githubapp.model.network.WebAccess
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBtn.setOnClickListener {searchGithub("tetris") }
    }

    private fun searchGithub(query: String) {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.IO) {
            val webResponse = WebAccess.githubApi.searchQuery(query)
            Log.v("primjer", webResponse.items[0].owner.login)

        }
    }
}
