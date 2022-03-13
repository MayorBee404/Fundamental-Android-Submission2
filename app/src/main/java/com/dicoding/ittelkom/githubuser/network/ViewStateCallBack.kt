package com.dicoding.ittelkom.githubuser.network

import android.view.View
import com.dicoding.ittelkom.githubuser.R
import com.dicoding.ittelkom.githubuser.databinding.FollowerFragmentBinding
import com.dicoding.ittelkom.githubuser.ui.follow.FollowerFragment
import kotlin.properties.ReadOnlyProperty

interface ViewStateCallBack<T> {
    fun onSuccess(data: T)
    fun onLoading()
    fun onFailed(message: String?)

    val invisible: Int
        get() = View.INVISIBLE

    val visible: Int
        get() = View.VISIBLE
}