package com.example.marsroverphotos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MainScreen(viewModel: PhotosViewModel = hiltViewModel()){

    val state = viewModel.state
//    val state = viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar {
                Icon(
                    Icons.Outlined.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(70.dp)
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)){

            LazyColumn{
                items(state.value){

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        elevation = 5.dp
                    ){
                        Box(modifier = Modifier.height(200.dp)){
                            GlideImage(
                                imageModel = {it.imgSrc.toHttpsPrefix()},
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
                                    Text("Earth date: ${it.earthDate}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                                    Text("Rover Name: ${it.rover.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                                    Text("Sol: ${it.sol}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                                    Text("Camera: ${it.camera.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)

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
