package com.clean.cut.githubapp.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import com.clean.cut.githubapp.R
import com.clean.cut.githubapp.data.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_repository_details.*
import kotlinx.android.synthetic.main.activity_user_details.*
import kotlinx.android.synthetic.main.github_rv_item.view.*

class RepositoryDetailsActivity : AppCompatActivity() {
    private lateinit var repositoryDetails: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_details)

        initialize()
    }

    private fun initialize() {
        repositoryDetails = intent.getSerializableExtra("data") as Item

        repNameTv.text = repositoryDetails.name
        descriptionTv.text = repositoryDetails.description
        createdTv.text = repositoryDetails.createdAt
        updatedTv.text = repositoryDetails.updatedAt
        pushedTv.text = repositoryDetails.pushedAt
        languageTv.text = repositoryDetails.language
        scoreTv.text = repositoryDetails.score.toString()

    }

    fun openWeb(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(repositoryDetails.htmlUrl))
        startActivity(browserIntent)
    }
    fun openUser(view: View) {
        val intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra("data", repositoryDetails)
        startActivity(intent)
    }
}
