package com.dicoding.ittelkom.githubuser.ui.detailuser

import android.annotation.SuppressLint
import android.content.Intent.EXTRA_USER
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.ittelkom.githubuser.R
import com.dicoding.ittelkom.githubuser.databinding.DetailUserBinding
import com.dicoding.ittelkom.githubuser.model.DetailResource
import com.dicoding.ittelkom.githubuser.network.Resource
import com.dicoding.ittelkom.githubuser.network.ViewStateCallBack
import com.dicoding.ittelkom.githubuser.ui.adapter.FollowPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailUser : AppCompatActivity(), ViewStateCallBack<DetailResource?> {

    companion object {

        private val TAB_TITLES = intArrayOf(
            R.string.followers,
            R.string.following
        )
    }

    private lateinit var detailUserBinding: DetailUserBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailUserBinding = DetailUserBinding.inflate(layoutInflater)
        setContentView(detailUserBinding.root)
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            elevation = 0f
        }

        val login = intent.getStringExtra(EXTRA_USER)


            viewModel.getDetailUser(login).observe(this) {
                when (it) {
                    is Resource.Error-> onFailed(it.message)
                    is Resource.Loading-> onLoading()
                    is Resource.Success-> onSuccess(it.data)
                }
        }

        val pageAdapter = FollowPagerAdapter(this, login.toString())

        detailUserBinding.apply {
            viewPager.adapter = pageAdapter
            TabLayoutMediator(tabs, viewPager) { tabs, position ->
                tabs.text = resources.getString(TAB_TITLES[position])
            }.attach()

            detailProgressBar.visibility = visible
            viewPager.visibility = invisible
            tabs.visibility = invisible
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

   @SuppressLint("SetTextI18n")
   override fun onSuccess(data: DetailResource?) {
        detailUserBinding.apply {
                detailRepository.text = "Repository : ${data?.publicRepos.toString()}"
                detailFollowers.text = "Followers : ${data?.followers.toString()}"
                detailFollowing.text = "Following : ${data?.following.toString()}"
                detailUsername.text = data?.login
                detailName.text = data?.name
                detailCompany.text = data?.company
                detailLocation.text = data?.location
            detailProgressBar.visibility = invisible
            relativeLayout.visibility = visible
            tabs.visibility = visible
            viewPager.visibility = visible

            detailAvatar.visibility = visible

                Glide.with(this@DetailUser)
                    .load(data?.avatarUrl)
                    .apply(RequestOptions().override(80, 80))
                    .into(detailAvatar)

                supportActionBar?.title = data?.login


        }
    }

    override fun onLoading() {
        detailUserBinding.apply {
            detailProgressBar.visibility = visible
            relativeLayout.visibility = invisible
            viewPager.visibility = invisible
            tabs.visibility = invisible
        }

    }

   override fun onFailed(message: String?) {

    }

}