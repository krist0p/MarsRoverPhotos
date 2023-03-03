package com.example.marsroverphotos.network.responses

import com.example.marsroverphotos.BuildConfig
import com.example.marsroverphotos.network.Dto.DtoPhotos
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    companion object{
        const val key = BuildConfig.API_KEY
    }
    @GET("/mars-photos/api/v1/rovers/curiosity/photos?api_key=$key")
    suspend fun fetchAll(
//    @Query("api_key") api_key: String = key,
    @Query("page") page: Int = 2,
    @Query("sol") sol: Int = 1000
    ): DtoPhotos

}