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
