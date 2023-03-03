package com.example.marsroverphotos.network.Dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DtoPhotoX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("sol")
    val sol: Int,
    @SerializedName("camera")
    val camera: DtoCamera,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("earth_date")
    val earthDate: String,
    @SerializedName("rover")
    val rover: DtoRover
)