package com.example.apiintegrationv4.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun FavoritesScreen(navController: NavController) {
    val favoriteCities = listOf("Stockholm", "Paris", "New York") // Placeholder data

    Column {
        Text("Favorite Locations")

        LazyColumn {
            items(favoriteCities) { city ->
                Text(city)
            }
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}
