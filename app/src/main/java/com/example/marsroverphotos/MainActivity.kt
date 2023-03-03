package com.example.marsroverphotos

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestListener
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import com.example.marsroverphotos.util.ImageUtils.Companion.DEFAULT_RECIPE_IMAGE
import com.skydoves.landscapist.DataSource
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoverPhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    navController = rememberNavController()
                    NavGraph(navHostController = navController)

                }
            }
        }
    }
}






//@Composable
//private fun MainScreen(viewModel: PhotosViewModel = hiltViewModel()){
//
////    val state = viewModel.state
//    val state = viewModel.state.collectAsState()
//    Scaffold(
//        topBar = {
//            TopAppBar {
//                Icon(
//                    Icons.Outlined.Menu,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(12.dp)
//                        .height(70.dp)
//                )
//            }
//        }
//    ) {
//        Column(modifier = Modifier.padding(it)){
//
//            LazyColumn{
//                items(state.value){
//
//                    Card(
//                        modifier = Modifier.fillMaxWidth(),
//                        shape = RoundedCornerShape(15.dp),
//                        elevation = 5.dp
//                    ){
//                        Box(modifier = Modifier.height(200.dp)){
//                            GlideImage(
//                                imageModel = {it.imgSrc.toHttpsPrefix()},
//                                success = {
//                                    Image(
//                                        bitmap = it.imageBitmap!!,
//                                        contentScale = ContentScale.Crop,
//                                        contentDescription = null,
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                    )
//                                }
//                            )
//                            Box(modifier = Modifier
//                                .fillMaxSize()
//                                .background(
//                                    Brush.verticalGradient(
//                                        colors = listOf(
//                                            Color.Transparent,
//                                            Color.Black
//                                        ),
//                                        startY = 300f
//                                    )
//                                )
//                            )
//
//                            Box(modifier = Modifier
//                                .fillMaxHeight()
//                                .padding(12.dp),
//                                contentAlignment = Alignment.BottomStart
//                            ){
//                                Column() {
//                                    Text("Earth date: ${it.earthDate}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//                                    Text("Rover Name: ${it.rover.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//                                    Text("Sol: ${it.sol}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//                                    Text("Camera: ${it.camera.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//
//                                }
//
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//
//
//    }
//
//}
//
//fun String.toHttpsPrefix(): String? = if (isNotEmpty() && !startsWith("https://") && !startsWith("http://")) {
//    "https://$this"
//} else if (startsWith("http://")) {
//    replace("http://", "https://")
//} else this



//@Composable
//private fun ItemsList(viewModel: PhotosViewModel){
//
//
////    val viewModel = remember{
////        PhotosViewModel()
////    }
//
//    val state = viewModel.state
//
//    LazyColumn{
//        items(state.value){
//
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(15.dp),
//                elevation = 5.dp
//            ){
//                Box(modifier = Modifier.height(200.dp)){
//                    GlideImage(
//                        imageModel = {it.imgSrc.toHttpsPrefix()},
//                        success = {
//                            Image(
//                                bitmap = it.imageBitmap!!,
//                                contentScale = ContentScale.Crop,
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                            )
//                        }
//                    )
//                    Box(modifier = Modifier
//                        .fillMaxSize()
//                        .background(
//                            Brush.verticalGradient(
//                                colors = listOf(
//                                    Color.Transparent,
//                                    Color.Black
//                                ),
//                                startY = 300f
//                            )
//                        )
//                    )
//
//                    Box(modifier = Modifier
//                        .fillMaxHeight()
//                        .padding(12.dp),
//                        contentAlignment = Alignment.BottomStart
//                    ){
//                        Column() {
//                            Text("Earth date: ${it.earthDate}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//                            Text("Rover Name: ${it.rover.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//                            Text("Sol: ${it.sol}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//                            Text("Camera: ${it.camera.name}", style = TextStyle(color = Color.White), fontSize = 16.sp)
//
//                        }
//
//                    }
//                }
//
//            }
//        }
//    }
//}


