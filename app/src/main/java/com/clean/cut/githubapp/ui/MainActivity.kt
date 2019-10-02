package com.clean.cut.githubapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.clean.cut.githubapp.R
import com.clean.cut.githubapp.data.Item
import com.clean.cut.githubapp.databinding.ActivityMainBinding
import com.clean.cut.githubapp.util.GithubRecyclerViewAdapter
import com.clean.cut.githubapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: GithubRecyclerViewAdapter
    private var listItems:MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialize()

        //fetch data and update adapter
        viewModel.liveDataQueryResult.observe(this, Observer {
            listItems.clear()
            listItems.addAll(it.items)
            adapter.notifyDataSetChanged()
        })
    }

    private fun initialize() {
        //boilerplate
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        //recyclerview
        linearLayoutManager = LinearLayoutManager(this)
        githubRV.layoutManager = linearLayoutManager
        adapter = GithubRecyclerViewAdapter(listItems)
        githubRV.adapter = adapter
    }


    fun sortByUpdated(view: View) {
        listItems.sortByDescending {it.updatedAt}
        adapter.notifyDataSetChanged()
    }
    fun sortByForks(view: View) {
        listItems.sortByDescending {it.forksCount}
        adapter.notifyDataSetChanged()
    }
    fun sortByStars(view: View) {
        listItems.sortByDescending {it.stargazersCount}
        adapter.notifyDataSetChanged()
    }


}
