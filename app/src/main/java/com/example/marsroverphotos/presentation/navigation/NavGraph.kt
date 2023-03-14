package com.example.marsroverphotos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marsroverphotos.presentation.view_photo_screen.ViewPhotoScreen
import com.example.marsroverphotos.presentation.main_screen.MainScreen


@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){ MainScreen(navHostController) }


        composable(
            route = Screen.ViewPhotoScreen.route,
            arguments = listOf(
                navArgument("url"){
                    type = NavType.StringType
                },
                    navArgument("earthDate"){
                    type = NavType.StringType
                },
                navArgument("roverName"){
                    type = NavType.StringType
                },    navArgument("sol"){
                    type = NavType.StringType
                },    navArgument("cameraName"){
                    type = NavType.StringType
                },    navArgument("roverLandingDate"){
                    type = NavType.StringType
                },    navArgument("roverStatus"){
                    type = NavType.StringType
                }
            )
        ){
            ViewPhotoScreen(navHostController,
                it.arguments?.getString("url"),
                it.arguments?.getString("earthDate"),
                it.arguments?.getString("roverName"),
                it.arguments?.getString("sol"),
                it.arguments?.getString("cameraName"),
                it.arguments?.getString("roverLandingDate"),
                it.arguments?.getString("roverStatus")
            ) }
    }

}