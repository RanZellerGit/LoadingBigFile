package com.example.bigfileexample

import com.google.gson.annotations.SerializedName

data class DataHolder(
    @SerializedName("data")
    val data: Array<DataItem>
)

data class DataItem(
    @SerializedName("about") val about: String,
    @SerializedName("email") val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("hash") val hash: String,
    @SerializedName("id") val id: Long,
    @SerializedName("ip_address") val ipAddress: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("name") val name: Name,
    @SerializedName("tags") val tags: Array<String>
)

data class Name(
    @SerializedName("first") val first: String,
    @SerializedName("second") val second: String
)