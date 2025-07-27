package com.example.apiintegrationv4.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.apiintegrationv4.screens.*

sealed class Screen(val route: String) {
    object Home : Screen("homeScreen")
    object CurrentWeather : Screen("currentWeatherScreen")
    object SearchWeather : Screen("searchWeatherScreen")
    object Favorites : Screen("favoritesScreen")
}

@Composable
fun SetupNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.CurrentWeather.route) { CurrentWeatherScreen(navController) }
        composable(Screen.SearchWeather.route) { SearchWeatherScreen(navController) }
        composable(Screen.Favorites.route) { FavoritesScreen(navController) }
    }
}
