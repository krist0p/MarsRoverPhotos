package com.example.marsroverphotos.presentation.view_photo_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marsroverphotos.presentation.main_screen.toHttpsPrefix
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
            .padding(12.dp)
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

        Text(text = "Earth date: ${earthDate!!}")
        Text(text = "Rover Name: ${roverName!!}")
        Text(text = "Sol: ${sol!!}")
        Text(text = "Camera: ${cameraName!!}")
        Text(text = "Rover landing date: ${roverLandingDate!!}")
        Text(text = "Rover status:${roverStatus!!}")


    }
}
