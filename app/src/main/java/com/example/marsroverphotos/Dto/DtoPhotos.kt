package com.example.marsroverphotos.Dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DtoPhotos(
    @SerializedName("photos")
    val photos: List<DtoPhotoX>
)