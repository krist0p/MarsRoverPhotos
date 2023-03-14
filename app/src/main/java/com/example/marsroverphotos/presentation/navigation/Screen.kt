package com.example.marsroverphotos.presentation.navigation

sealed class Screen(val route: String){
    object MainScreen: Screen(route = "main_screen")

//    object ViewPhotoScreen: Screen(route = "view_photo_screen")


//    object ViewPhotoScreen: Screen(route = "view_photo_screen/{url}")

//    object ViewPhotoScreen: Screen(route = "view_photo_screen/{url}/{earthDate}")

    object ViewPhotoScreen: Screen(route = "view_photo_screen/{url}/{earthDate}/{roverName}/{sol}/{cameraName}/{roverLandingDate}/{roverStatus}")


}
