package com.example.marsroverphotos

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsroverphotos.network.Dto.DtoPhotoX
import com.example.marsroverphotos.network.responses.PhotoApi
import com.example.marsroverphotos.repository.PhotoRepository
import com.example.marsroverphotos.repository.PhotoRepository_Impl
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PhotosViewModel

@Inject
    constructor(
    private val repository: PhotoRepository,
    private val apiKey: String)
    : ViewModel() {


    val state: MutableState<List<DtoPhotoX>> = mutableStateOf(emptyList<DtoPhotoX>())

//    val state = MutableStateFlow(emptyList<DtoPhotoX>())
    init{
        viewModelScope.launch(Dispatchers.IO) {
            val photosFromRepo = repository.get(token = apiKey, page = 1, sol = 3000)

            state.value = photosFromRepo.photos

        }
    }
}
