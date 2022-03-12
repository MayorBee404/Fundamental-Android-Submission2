package com.dicoding.ittelkom.githubuser.ui.detailuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.ittelkom.githubuser.databinding.DetailUserBinding
import com.dicoding.ittelkom.githubuser.model.UserResponse

/*class DetailUser : AppCompatActivity(), ViewStateCallback<UserResponse?>{
    private lateinit var detailBinding : DetailUserBinding
    private lateinit var viewModel : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = DetailUserBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            elevation = 0f
        }

    }
}*/