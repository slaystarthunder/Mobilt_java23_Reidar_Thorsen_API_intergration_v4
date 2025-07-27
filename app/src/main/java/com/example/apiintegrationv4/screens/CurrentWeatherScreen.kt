package com.example.apiintegrationv4.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apiintegrationv4.network.RetrofitInstance
import com.example.apiintegrationv4.repository.WeatherRepository
import com.example.apiintegrationv4.viewmodel.WeatherViewModel
import com.example.apiintegrationv4.viewmodel.WeatherViewModelFactory

@Composable
fun CurrentWeatherScreen(navController: NavController) {
    val repository = remember { WeatherRepository(RetrofitInstance.api) }
    val viewModel: WeatherViewModel = viewModel(factory = WeatherViewModelFactory(repository))
    val weatherState by viewModel.weatherState.collectAsState()

    Column {
        Text("Current Weather in Stockholm")
        weatherState?.let { weather ->
            Text("Temperature: ${weather.main.temp}°C")
        } ?: Text("Loading...")

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}
