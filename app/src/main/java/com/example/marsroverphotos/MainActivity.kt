package com.example.marsroverphotos

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import com.example.marsroverphotos.util.ImageUtils.Companion.DEFAULT_RECIPE_IMAGE
import com.skydoves.landscapist.DataSource
import com.skydoves.landscapist.glide.GlideImage



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoverPhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ItemsList()

                }
            }
        }
    }
}





@Composable
private fun ItemsList(){
    val viewModel = remember{
        PhotosViewModel(api = NetworkModule().api)
    }

    val state = viewModel.state.collectAsState()

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
                            Text("id: ${it.id}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                            Text("Earth date: ${it.earthDate}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                            Text("Rover Name: ${it.rover.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
                            Text("Sol: ${it.sol}", style = TextStyle(color = Color.White), fontSize = 16.sp)
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

