package com.example.marsroverphotos.di

import com.example.marsroverphotos.network.responses.PhotoApi
import com.example.marsroverphotos.repository.PhotoRepository
import com.example.marsroverphotos.repository.PhotoRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun providePhotoRepository(photoApi: PhotoApi):PhotoRepository{
        return PhotoRepository_Impl(photoApi)
    }
}