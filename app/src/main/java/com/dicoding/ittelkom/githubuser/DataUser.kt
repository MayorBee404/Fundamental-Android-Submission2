package com.dicoding.ittelkom.githubuser

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize

data class DataUser(
    var avatar : Int?,
    var name: String?,
    var username: String?,
    var company: String?,
    var location: String?,
    var repository: String?,
    var followers: String?,
    var following: String?
) : Parcelable


