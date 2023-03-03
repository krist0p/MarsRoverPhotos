package com.example.marsroverphotos.di

import com.example.marsroverphotos.BuildConfig
import com.example.marsroverphotos.network.responses.PhotoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkService(): PhotoApi{
        return Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideApiKey(): String{
        return BuildConfig.API_KEY
    }

}

