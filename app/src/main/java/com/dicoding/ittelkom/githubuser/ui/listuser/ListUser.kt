package com.dicoding.ittelkom.githubuser.ui.listuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.ittelkom.githubuser.R
import com.dicoding.ittelkom.githubuser.databinding.ListUserBinding
import com.dicoding.ittelkom.githubuser.model.DetailResource
import com.dicoding.ittelkom.githubuser.network.Resource
import com.dicoding.ittelkom.githubuser.network.ViewStateCallBack
import com.dicoding.ittelkom.githubuser.ui.adapter.ListUserAdapter


class ListUser : AppCompatActivity(),ViewStateCallBack<List<DetailResource>>{

    private lateinit var listUserBinding: ListUserBinding
    private lateinit var userQuery: String
    private lateinit var viewModel: ListUserModel
    private lateinit var userAdapter: ListUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listUserBinding = ListUserBinding.inflate(layoutInflater)
        setContentView(listUserBinding.root)

        viewModel = ViewModelProvider(this)[ListUserModel::class.java]
        userAdapter = ListUserAdapter()
        listUserBinding.includeMainSearch.rvListUser.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@ListUser, LinearLayoutManager.VERTICAL, false)

        }

        listUserBinding.searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    userQuery = query.toString()
                    clearFocus()
                    viewModel.searchUser(userQuery).observe(this@ListUser) {
                        when (it) {
                            is Resource.Error -> onFailed(it.message)
                            is Resource.Loading-> onLoading()
                            is Resource.Success -> it.data?.let { it1 -> onSuccess(it1) }
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.custom_menu, menu)
        return true
    }
    override fun onSuccess(data: List<DetailResource>) {
        userAdapter.setAllData(data)
        listUserBinding.includeMainSearch.apply {
            ivSearchIcon.visibility = invisible
            tvMessage.visibility = invisible
            mainProgressBar.visibility = invisible
            rvListUser.visibility = visible
        }
    }

    override fun onLoading() {
        listUserBinding.includeMainSearch.apply {
            ivSearchIcon.visibility = invisible
            tvMessage.visibility = invisible
            mainProgressBar.visibility = visible
            rvListUser.visibility = invisible
        }
    }

    override fun onFailed(message: String?) {
        listUserBinding.includeMainSearch.apply {
            if (message == null) {
                ivSearchIcon.apply {
                    setImageResource(R.drawable.ic_search_on)
                    visibility = visible
                }
                tvMessage.apply {
                    text = resources.getString(R.string.user_not_found)
                    visibility = visible
                }
            } else {
                ivSearchIcon.apply {
                    setImageResource(R.drawable.ic_baseline_search_24)
                    visibility = visible
                }
                tvMessage.apply {
                    text = message
                    visibility = visible
                }
            }
            mainProgressBar.visibility = invisible
            rvListUser.visibility = invisible
        }
    }


}