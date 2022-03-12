package com.dicoding.ittelkom.githubuser.ui.listuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.dicoding.ittelkom.githubuser.model.SearchUserResponse
import com.dicoding.ittelkom.githubuser.model.UserResponse
import com.dicoding.ittelkom.githubuser.network.ApiConfig
import com.dicoding.ittelkom.githubuser.network.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUserModel:ViewModel() {
    private val retrofit = ApiConfig.getApiService()
    private val user = MutableLiveData<com.dicoding.ittelkom.githubuser.network.Resource<UserResponse>>()

    fun searchUser(query: String): MutableLiveData<com.dicoding.ittelkom.githubuser.network.Resource<UserResponse>> {
        user.postValue(com.dicoding.ittelkom.githubuser.network.Resource.Loading())
        retrofit.searchUsers(query).enqueue(object : Callback<SearchUserResponse> {
            override fun onResponse(
                call: Call<SearchUserResponse>,
                response: Response<SearchUserResponse>
            ) {
                val list = response.body()?.items
                if (list.isNullOrEmpty())
                    user.postValue(com.dicoding.ittelkom.githubuser.network.Resource.Error(null))
                else
                    user.postValue(com.dicoding.ittelkom.githubuser.network.Resource.Success(list))
            }

            override fun onFailure(call: Call<SearchUserResponse>, t: Throwable) {
                user.postValue(com.dicoding.ittelkom.githubuser.network.Resource.Error(t.message))
            }

        })
        return user
    }


}