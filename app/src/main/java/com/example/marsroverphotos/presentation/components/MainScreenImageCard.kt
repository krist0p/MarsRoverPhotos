package com.example.marsroverphotos.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marsroverphotos.network.Dto.DtoPhotoX
import com.example.marsroverphotos.presentation.util.toHttpsPrefix
import com.example.marsroverphotos.ui.theme.bebasNeueFamily
import com.skydoves.landscapist.glide.GlideImage
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun MainScreenImageCard(
    navController: NavController,
    photo: DtoPhotoX
){
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
                    Text("Earth date: ${photo.earthDate}", style = TextStyle(color = Color.White, fontFamily = bebasNeueFamily, fontWeight = FontWeight.Light), fontSize = 16.sp)
                    Text("Rover Name: ${photo.rover.name}", style = TextStyle(color = Color.White, fontFamily = bebasNeueFamily, fontWeight = FontWeight.Light), fontSize = 16.sp)
                    Text("Sol: ${photo.sol}", style = TextStyle(color = Color.White, fontFamily = bebasNeueFamily, fontWeight = FontWeight.Light), fontSize = 16.sp)

                }

            }
        }

    }
}