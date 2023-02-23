package com.example.marsroverphotos

import com.example.marsroverphotos.Dto.DtoPhotos
import retrofit2.http.GET

interface PhotoApi {

    companion object{
        const val key = BuildConfig.API_KEY
    }

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=1&api_key=$key")
    suspend fun fetchAll(): DtoPhotos
}