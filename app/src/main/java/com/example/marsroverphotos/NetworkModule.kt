package com.example.marsroverphotos

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {

    private val okHttpClient = OkHttpClient()

    val api: PhotoApi by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApi::class.java)
    }


    companion object {
        const val BASE_URL = "https://api.nasa.gov/"
    }

}