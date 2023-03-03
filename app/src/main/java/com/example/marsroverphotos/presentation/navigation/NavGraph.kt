package com.example.marsroverphotos

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marsroverphotos.presentation.navigation.Screen


@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.FilterResultsScreen.route){
        composable(route = Screen.MainScreen.route){ MainScreen(navHostController) }
        composable(route = Screen.FilterResultsScreen.route){ FilterResults(navHostController)}
    }

}