package com.dicoding.ittelkom.githubuser.network
import com.dicoding.ittelkom.githubuser.model.SearchUserResponse
import com.dicoding.ittelkom.githubuser.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @Headers("Authorization: token <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>")
    @GET("users/{username}")
    fun getDetailUser(
        @Path("id") id: String
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
