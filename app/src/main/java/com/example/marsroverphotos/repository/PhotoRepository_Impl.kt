package com.example.marsroverphotos.repository

import com.example.marsroverphotos.network.Dto.DtoPhotos
import com.example.marsroverphotos.network.responses.PhotoApi

class PhotoRepository_Impl(
    private val photoApi: PhotoApi
): PhotoRepository {
    override suspend fun get(page: Int, sol: Int): DtoPhotos {
        val result = photoApi.fetchAll(page, sol)

        return result
    }
}