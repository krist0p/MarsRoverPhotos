package com.example.marsroverphotos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marsroverphotos.presentation.main_screen.MainScreenViewModel
import com.example.marsroverphotos.presentation.main_screen.PAGE_SIZE
import com.example.marsroverphotos.presentation.navigation.Screen
import com.example.marsroverphotos.ui.theme.BlackBean1
import com.example.marsroverphotos.ui.theme.BlackBean3
import com.example.marsroverphotos.ui.theme.Peach
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = hiltViewModel()){


    val viewModel = viewModel

    val state = viewModel.state

    val loading = viewModel.loading.value

    val page = viewModel.page.value

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(60.dp),
                backgroundColor = BlackBean1

                ) {
                Icon(
                    Icons.Outlined.Menu,
                    tint = Peach,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(40.dp)
                        .clickable {
                            navController.navigate(Screen.FilterResultsScreen.route)
                        }
                )
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .background(BlackBean3)){

            LazyColumn{
                itemsIndexed(state.value){ index, photo ->


                    viewModel.onChangeRecipeScrollPosition(index)


                    if((index + 1) >= (page * PAGE_SIZE) && !loading){
                        viewModel.nextPage()
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        shape = RoundedCornerShape(15.dp),
                        elevation = 5.dp
                    ){
                        Box(modifier = Modifier.height(200.dp)){
                            GlideImage(
                                imageModel = {photo.imgSrc.toHttpsPrefix()},
                                success = {
                                    Image(
                                        bitmap = it.imageBitmap!!,
                                        contentScale = ContentScale.Crop,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )
                                }
                            )
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black
                                        ),
                                        startY = 300f
                                    )
                                )
                            )

                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .padding(12.dp),
                                contentAlignment = Alignment.BottomStart
                            ){
                                Column() {
                                    Text("Earth date: ${photo.earthDate}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                                    Text("Rover Name: ${photo.rover.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                                    Text("Sol: ${photo.sol}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                                    Text("Camera: ${photo.camera.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)

                                }

                            }
                        }

                    }
                }
            }
        }


    }

}

fun String.toHttpsPrefix(): String? = if (isNotEmpty() && !startsWith("https://") && !startsWith("http://")) {
    "https://$this"
} else if (startsWith("http://")) {
    replace("http://", "https://")
} else this
