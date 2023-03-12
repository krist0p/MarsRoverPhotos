package com.example.marsroverphotos.presentation.main_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsroverphotos.network.Dto.DtoPhotoX
import com.example.marsroverphotos.network.Dto.DtoPhotos
import com.example.marsroverphotos.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


const val PAGE_SIZE = 25

@HiltViewModel
class MainScreenViewModel

@Inject
    constructor(
    private val repository: PhotoRepository,
    private val apiKey: String)
    : ViewModel() {


    val state: MutableState<List<DtoPhotoX>> = mutableStateOf(listOf())

    val query = mutableStateOf("")

    val loading = mutableStateOf(false)

    val page = mutableStateOf(1)

    var recipeListScrollPosition = 0

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val photosFromRepo = repository.get(
                token = apiKey,
                page = 1,
                sol = "1000"
            )

            state.value = photosFromRepo.photos

        }
    }


    fun nextPage() {
        viewModelScope.launch(Dispatchers.IO) {


            if ((recipeListScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
                loading.value = true
                incrementPage()


                if (page.value > 1) {
                    val result = repository.get(
                        token = apiKey,
                        page = page.value,
                        sol = "1000"
                    )
                    appendList(result.photos)
                }
                loading.value = false
            }

        }
    }

        private fun appendList(state: List<DtoPhotoX>){
        val current = ArrayList(this.state.value)
        current.addAll(state)
        this.state.value = current
    }

    private fun incrementPage() {
        page.value = page.value + 1
    }

    fun onChangeRecipeScrollPosition(position: Int){
        recipeListScrollPosition = position
    }

//    fun clearSelectedCategory(){
//        selectedCategory.value = null
//    }

//    fun resetSearchState(){
//        recipes.value = listOf()
//        page.value = 1
//        onChangeRecipeScrollPosition(0)
//        if(selectedCategory.value?.value != query.value)
//            clearSelectedCategory()
//    }

//    fun onSelectedCategoryChanged(category: String){
//        val newCategory = getFoodCategory(category)
//        selectedCategory.value = newCategory
//        onQueryChanged(category)
//    }


}