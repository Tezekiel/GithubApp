package com.clean.cut.githubapp.util

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.clean.cut.githubapp.R
import com.clean.cut.githubapp.data.Item
import com.clean.cut.githubapp.ui.RepositoryDetailsActivity
import com.clean.cut.githubapp.ui.UserDetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.github_rv_item.view.*

class GithubRecyclerViewAdapter(private val repoDetails: List<Item>) :
    RecyclerView.Adapter<GithubRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflatedView = parent.inflate(R.layout.github_rv_item, false)
        return Holder(inflatedView)
    }

    override fun getItemCount(): Int {
        return repoDetails.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val repoDetail = repoDetails[position]
        holder.bindResult(repoDetail)
    }

    class Holder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var searchResult: Item? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            //start RepositoryDetails activity
            val intent = Intent(v.context, RepositoryDetailsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("data", searchResult)
            v.context.startActivity(intent)
        }

        fun bindResult(searchResult: Item) {
            this.searchResult = searchResult
            Picasso.with(view.context).load(searchResult.owner.avatarUrl).into(view.userImageIv)

            //start userDetails activity
            view.userImageIv.setOnClickListener {
                val intent = Intent(view.userImageIv.context, UserDetailsActivity::class.java)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(view.userImageIv.context as Activity,
                    view.userImageIv, "avatarTransition").toBundle()
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("data", searchResult)
                view.userImageIv.context.startActivity(intent, options)
            }

            view.repoNameTv.text = searchResult.name
            view.userNameTv.text = searchResult.owner.login
            view.watchersTv.text = searchResult.watchersCount.toString()
            view.forksTv.text = searchResult.forksCount.toString()
            view.issuesTv.text = searchResult.openIssuesCount.toString()
        }

    }
}