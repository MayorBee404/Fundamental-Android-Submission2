package com.dicoding.ittelkom.githubuser.network
import com.dicoding.ittelkom.githubuser.model.SearchUserResponse
import com.dicoding.ittelkom.githubuser.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @Headers("Authorization: token <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>")
    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username: String
    ): Call<UserResponse>

    @GET("search/users")
    fun searchUsers (
        @Query("q")
        query: String
    ): Call<SearchUserResponse>

    @GET("users/{username}/followers")
    fun getUserFollowers (
        @Path("username")
        username: String
    ): Call<List<UserResponse>>

    @GET("users/{username}/following")
    fun getUserFollowing (
        @Path("username")
        username: String
    ): Call<List<UserResponse>>

}
