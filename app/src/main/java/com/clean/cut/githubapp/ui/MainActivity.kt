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

        searchBtn.setOnClickListener { v -> searchGithub("tetris") }
    }

    private fun searchGithub(query: String) {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.IO) {
            val webResponse = WebAccess.githubApi.searchQuery(query)
            Log.v("primjer", "ovdje")
            Log.v("primjer", webResponse)

           /* if (webResponse) {

                //val responseObject: List<ResponseLogin>? = webResponse.body()
                val responseObject: String? = webResponse.toString() //za debugg
                Log.v("primjer", responseObject)

                //TODO if ok start activity
                //startActivity(Intent(this@LoginActivity, MainActivity::class.java))

            } else {
                Log.d("primjer", "Error $webResponse")
                //Toast.makeText(this@MainActivity, "Error ${webResponse.code()}", Toast.LENGTH_SHORT).show()
            }*/
        }
    }
}
