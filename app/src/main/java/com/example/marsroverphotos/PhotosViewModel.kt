package com.example.marsroverphotos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsroverphotos.Dto.DtoPhotoX
import com.example.marsroverphotos.Dto.DtoPhotos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PhotosViewModel(private val api: PhotoApi): ViewModel() {

    val state = MutableStateFlow(emptyList<DtoPhotoX>())
    init{
        viewModelScope.launch(Dispatchers.IO) {

            val photos = api.fetchAll().photos

            state.value = photos

        }
    }
}
