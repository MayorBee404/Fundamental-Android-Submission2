package com.dicoding.ittelkom.githubuser.network
import com.dicoding.ittelkom.githubuser.model.SearchUserResponse
import com.dicoding.ittelkom.githubuser.model.DetailResource
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetailUser(
        @Path("username")
        login: String
    ): Call<DetailResource>

    @GET("search/users")
    @Headers("Authorization: token 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")
    fun searchUsers (
        @Query("q")
        query: String
    ): Call<SearchUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getUserFollowers (
        @Path("username")
        login: String
    ): Call<List<DetailResource>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getUserFollowing (
        @Path("username")
        login: String
    ): Call<List<DetailResource>>



}
