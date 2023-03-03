package com.example.marsroverphotos

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){ MainScreen() }
        composable(route = Screen.FilterResultsScreen.route){ FilterResults()}
    }

}