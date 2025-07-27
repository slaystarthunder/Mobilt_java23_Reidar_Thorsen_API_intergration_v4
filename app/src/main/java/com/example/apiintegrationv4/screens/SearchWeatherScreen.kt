package com.example.apiintegrationv4.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apiintegrationv4.network.RetrofitInstance
import com.example.apiintegrationv4.repository.WeatherRepository
import com.example.apiintegrationv4.viewmodel.WeatherViewModel
import com.example.apiintegrationv4.viewmodel.WeatherViewModelFactory

@Composable
fun SearchWeatherScreen(navController: NavController) {
    var city by remember { mutableStateOf("") }
    val repository = remember { WeatherRepository(RetrofitInstance.api) }
    val viewModel: WeatherViewModel = viewModel(factory = WeatherViewModelFactory(repository))
    val weatherState by viewModel.weatherState.collectAsState()

    Column {
        Text("Search Weather by City")

        TextField(
            value = city,
            onValueChange = {
                city = it
            },
            label = { Text("Enter city name") }
        )

        Button(onClick = {
            if (city.isNotBlank()) {
                viewModel.fetchWeather(city, "51d5271af4c421a8c9ab0b4fd3092ded")
            }
        }) {
            Text("Search")
        }

        // Display weather information or error messages
        if (weatherState != null) {
            val weather = weatherState!!
            Text("Temperature in $city: ${weather.main.temp}°C")
        } else if (city.isNotEmpty()) {
            Text("No results found. Please try again.")
        } else {
            Text("Enter a city to get the weather.")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}
