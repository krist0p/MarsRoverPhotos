package com.example.marsroverphotos.Dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DtoRover(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("landing_date")
    val landingDate: String,
    @SerializedName("launch_date")
    val launchDate: String,
    @SerializedName("status")
    val status: String
)