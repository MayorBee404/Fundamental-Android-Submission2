package com.dicoding.ittelkom.githubuser.network
import com.dicoding.ittelkom.githubuser.model.SearchUserResponse
import com.dicoding.ittelkom.githubuser.model.DetailResource
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @GET("users/{username}")
    fun getDetailUser(
        @Path("username")
        login: String
    ): Call<DetailResource>

    @GET("search/users")
    fun searchUsers (
        @Query("q")
        query: String
    ): Call<SearchUserResponse>

    @GET("users/{username}/followers")
    fun getUserFollowers (
        @Path("username")
        login: String
    ): Call<List<DetailResource>>


    @GET("users/{username}/following")
    fun getUserFollowing (
        @Path("username")
        login: String
    ): Call<List<DetailResource>>



}
