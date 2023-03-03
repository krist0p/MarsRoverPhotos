package com.example.marsroverphotos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsroverphotos.network.Dto.DtoPhotoX
import com.example.marsroverphotos.network.responses.PhotoApi
import com.example.marsroverphotos.repository.PhotoRepository_Impl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PhotosViewModel(private val api: PhotoApi): ViewModel() {

    val repo =  PhotoRepository_Impl(api)

    val state = MutableStateFlow(emptyList<DtoPhotoX>())
    init{
        viewModelScope.launch(Dispatchers.IO) {

//            val photos = api.fetchAll().photos

            val photosFromRepo = repo.get(1,1000)

            state.value = photosFromRepo.photos

        }
    }
}
