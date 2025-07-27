package com.example.apiintegrationv4.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Text("Welcome to WeatherNow!")
        Button(onClick = { navController.navigate("currentWeatherScreen") }) {
            Text("View Current Weather")
        }
        Button(onClick = { navController.navigate("searchWeatherScreen") }) {
            Text("Search Weather by City")
        }
        Button(onClick = { navController.navigate("favoritesScreen") }) {
            Text("Favorite Locations")
        }
    }
}
