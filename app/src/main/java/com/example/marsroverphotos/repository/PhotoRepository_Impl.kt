package com.example.marsroverphotos.repository

import com.example.marsroverphotos.network.Dto.DtoPhotos
import com.example.marsroverphotos.network.responses.PhotoApi

class PhotoRepository_Impl(
    private val photoApi: PhotoApi
): PhotoRepository {
    override suspend fun get(token: String, page: Int, sol: String): DtoPhotos {
        val result = photoApi.fetchAll(token, page, sol)

        return result
    }
}