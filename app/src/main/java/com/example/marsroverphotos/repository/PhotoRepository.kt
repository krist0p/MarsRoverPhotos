package com.example.marsroverphotos.repository

import com.example.marsroverphotos.network.Dto.DtoPhotos

interface PhotoRepository {

    suspend fun get(token: String, page: Int, sol: String): DtoPhotos
}