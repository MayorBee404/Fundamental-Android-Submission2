package com.dicoding.ittelkom.githubuser.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchUserResponse(
	@SerializedName("total_count") @Expose val totalResults: Long,
	@SerializedName("items") @Expose val items: List<UserResponse>
)

