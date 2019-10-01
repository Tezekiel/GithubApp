package com.clean.cut.githubapp.util

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clean.cut.githubapp.R
import com.clean.cut.githubapp.data.Item
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
            Log.d("primjer", "CLICK!")
        }

        fun bindResult(searchResult: Item) {
            this.searchResult = searchResult
            Picasso.with(view.context).load(searchResult.owner.avatarUrl).into(view.userImageIv)
            view.repoNameTv.text = searchResult.fullName
            view.userNameTv.text = searchResult.owner.login
        }

    }
}