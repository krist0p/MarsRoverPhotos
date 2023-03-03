package com.example.marsroverphotos.repository

import com.example.marsroverphotos.network.Dto.DtoPhotos

interface PhotoRepository {

    suspend fun get(page: Int, sol: Int): DtoPhotos
}