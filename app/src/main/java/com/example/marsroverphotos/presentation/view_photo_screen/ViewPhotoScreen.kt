package com.example.marsroverphotos.presentation.view_photo_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marsroverphotos.presentation.util.toHttpsPrefix
import com.example.marsroverphotos.ui.theme.BlackBean3
import com.example.marsroverphotos.ui.theme.Peach
import com.example.marsroverphotos.ui.theme.bebasNeueFamily
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ViewPhotoScreen(
    navController: NavController,
    url: String?,
    earthDate: String?,
    roverName: String?,
    sol: String?,
    cameraName: String?,
    roverLandingDate: String?,
    roverStatus: String?

) {




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBean3)
            .padding(18.dp)


    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)


        ){
            GlideImage(
                imageModel = { url!!.toHttpsPrefix() },
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
        }

        Text(text = "\n\nEarth date: $earthDate\n\nSol: $sol\n\nRover name: $roverName\n\nCamera: $cameraName\n\nRover landing date: $roverLandingDate\n\nRover status: $roverStatus",
            color = Peach,
            fontFamily = bebasNeueFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp)

    }
}
