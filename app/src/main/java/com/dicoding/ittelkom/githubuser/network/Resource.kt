package com.dicoding.ittelkom.githubuser.network

import com.dicoding.ittelkom.githubuser.model.UserResponse

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: List<UserResponse>?): Resource<T>(data)
    class Error<T>(message: String?, data: T? = null): Resource<T>(data, message)
    class Loading<T>(data: T? = null): Resource<T>(data)
}