package com.clean.cut.githubapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clean.cut.githubapp.R
import com.clean.cut.githubapp.data.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_details.*


class UserDetailsActivity : AppCompatActivity() {
    private lateinit var userDetails: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        initialize()
    }

    private fun initialize() {
        userDetails = intent.getSerializableExtra("data") as Item
        Picasso.with(this).load(userDetails.owner.avatarUrl).into(avatarIv)

        loginTv.text = userDetails.owner.login
        idTv.text = userDetails.owner.id.toString()
        nodeIdTv.text = userDetails.owner.nodeId
        gravatarIdTv.text = userDetails.owner.gravatarId
        urlTv.text = userDetails.owner.url
        receivedEvTv.text = userDetails.owner.receivedEventsUrl
        typeTv.text = userDetails.owner.type
    }

    fun openWeb(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(userDetails.htmlUrl?.substring(0, userDetails.htmlUrl!!.lastIndexOf('/'))))
        startActivity(browserIntent)
    }
}
