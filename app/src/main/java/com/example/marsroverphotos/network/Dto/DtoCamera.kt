package com.example.marsroverphotos.network.Dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DtoCamera(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rover_id")
    val roverId: Int,
    @SerializedName("full_name")
    val fullName: String
)