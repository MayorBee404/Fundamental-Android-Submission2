package com.dicoding.ittelkom.githubuser.ui.listuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.ittelkom.githubuser.model.SearchUserResponse
import com.dicoding.ittelkom.githubuser.model.UserResponse
import com.dicoding.ittelkom.githubuser.network.ApiConfig
import com.dicoding.ittelkom.githubuser.network.Resource

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUserModel:ViewModel() {
    private val retrofit = ApiConfig.getApiService()
    private val user = MutableLiveData<Resource<List<UserResponse>>>()

    fun searchUser(query: String): LiveData<Resource<List<UserResponse>>> {
        user.postValue(Resource.Loading())
        retrofit.searchUsers(query).enqueue(object : Callback<SearchUserResponse> {
            override fun onResponse(
                call: Call<SearchUserResponse>,
                response: Response<SearchUserResponse>
            ) {
                val list = response.body()?.items
                if (list.isNullOrEmpty())
                    user.postValue(Resource.Error(null))
                else
                    user.postValue(Resource.Success(list))
            }

            override fun onFailure(call: Call<SearchUserResponse>, t: Throwable) {
                user.postValue(Resource.Error(t.message))
            }

        })
        return user
    }


}