package com.example.marsroverphotos.network.responses

import com.example.marsroverphotos.BuildConfig
import com.example.marsroverphotos.network.Dto.DtoPhotos
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {


    @GET("/mars-photos/api/v1/rovers/curiosity/photos?")
    suspend fun fetchAll(
        @Query("api_key") key: String,
        @Query("page") page: Int,
        @Query("sol") sol: Int,
    ): DtoPhotos

}