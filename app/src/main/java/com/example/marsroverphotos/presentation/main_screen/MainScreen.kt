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
import com.example.marsroverphotos.ui.theme.*
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = hiltViewModel()){



    val state = viewModel.state


    //pagination
    val loading = viewModel.loading.value
    val page = viewModel.page.value

    //drawer
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val keyboardController = LocalSoftwareKeyboardController.current


    Scaffold(

        scaffoldState = scaffoldState,

        drawerContent = {

            Column(modifier = Modifier
                .fillMaxSize()
                .background(BlackBean1),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.height(150.dp))


                Box(modifier = Modifier
                    .padding(22.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(color = ChocolateCosmos),
                ){

                    Text(text = "Martian date (Sol): ",
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(16.dp),
                        color = Peach,
                        fontFamily = bebasNeueFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp

                    )
                    Text(text = "(A value in a range from 1000 to 3000)",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(16.dp),
                        color = Peach,
                        fontFamily = bebasNeueFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp

                    )

                    BasicTextField(
                        value = viewModel.query.value,
                        modifier = Modifier.align(Alignment.BottomCenter),

                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),



                        onValueChange = { newText ->
                        viewModel.changeQuery(newText)
                        },


                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = bebasNeueFamily,
                            fontWeight = FontWeight.Normal,
                            color = Peach,
                        ),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(BlackBean2)
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                innerTextField()
                            }
                        }
                    )
                }



                Spacer(modifier = Modifier.weight(1f))


                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {

                    Button(
                        onClick = {
                            viewModel.getData()
                            scope.launch { scaffoldState.drawerState.close()}
                        },
                        modifier = Modifier
                            .padding(30.dp)
                            .height(50.dp)
                            .width(250.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Peach,
                            contentColor = BlackBean1
                        )
                    )
                    {

                        Text(text = "Apply",
                            fontFamily = bebasNeueFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp)
                    }
                }

            }        },

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
                        .clickable
                            {
                                scope.launch { scaffoldState.drawerState.open() }
                            }

                )
            }
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

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .clickable {

                                val link = URLEncoder.encode(photo.imgSrc, StandardCharsets.UTF_8.toString())

                                navController.navigate("view_photo_screen"
                                        + "/"+ link
                                        +"/"+ photo.earthDate
                                        +"/"+ photo.rover.name
                                        +"/"+ photo.sol
                                        +"/"+ photo.camera.name
                                        +"/"+ photo.rover.landingDate
                                        +"/"+ photo.rover.status
                                )
                            },
                        shape = RoundedCornerShape(15.dp),
                        elevation = 5.dp
                    ){
                        Box(modifier = Modifier
                            .height(200.dp)

                            ){
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
                                Column {
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

fun String.toHttpsPrefix(): String = if (isNotEmpty() && !startsWith("https://") && !startsWith("http://")) {
    "https://$this"
} else if (startsWith("http://")) {
    replace("http://", "https://")
} else this
