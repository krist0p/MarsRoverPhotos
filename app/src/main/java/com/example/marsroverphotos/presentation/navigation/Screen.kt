package com.example.marsroverphotos.presentation.navigation

sealed class Screen(val route: String){
    object MainScreen: Screen(route = "main_screen")
    object FilterResultsScreen: Screen(route = "filter_results_screen")

}
