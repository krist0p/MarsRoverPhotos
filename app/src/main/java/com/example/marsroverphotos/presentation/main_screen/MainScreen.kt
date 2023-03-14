package com.example.marsroverphotos.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marsroverphotos.presentation.components.MainScreenDrawer
import com.example.marsroverphotos.presentation.components.MainScreenImageCard
import com.example.marsroverphotos.presentation.components.MainScreenTopAppBar
import com.example.marsroverphotos.ui.theme.*
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = hiltViewModel()){



    val state = viewModel.state


    val queryValue = viewModel.query.value

    //pagination
    val loading = viewModel.loading.value
    val page = viewModel.page.value

    //drawer
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    Scaffold(

        scaffoldState = scaffoldState,

        drawerContent = {

              MainScreenDrawer(
                  queryValue = queryValue,
                  changeQuery = viewModel::changeQuery,
                  getData = viewModel::getData,
                  scope = scope,
                  scaffoldState = scaffoldState
              )
                        },

        topBar = {

            MainScreenTopAppBar(
                scope = scope,
                scaffoldState = scaffoldState
            )

        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .background(BlackBean3)){

            LazyColumn{
                itemsIndexed(state.value){ index, photo ->

                    viewModel.onChangeRecipeScrollPosition(index)

                    if((index + 1) >= (page * PAGE_SIZE) && !loading){
                        viewModel.nextPage()
                    }
                        MainScreenImageCard(navController = navController, photo = photo)

                }
            }
        }
    }
}


