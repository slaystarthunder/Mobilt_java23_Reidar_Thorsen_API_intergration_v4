package com.example.apiintegrationv4.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiintegrationv4.api.OpenWeatherResponse
import com.example.apiintegrationv4.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherState = MutableStateFlow<OpenWeatherResponse?>(null)
    val weatherState: StateFlow<OpenWeatherResponse?> = _weatherState

    fun fetchWeather(city: String, apiKey: String) {
        Log.d("WeatherViewModel", "Initiating fetch for city: $city")
        viewModelScope.launch {
            try {
                val response = repository.fetchWeather(city, apiKey)
                Log.d("WeatherViewModel", "Weather data received: $response")
                _weatherState.value = response
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Error fetching weather: ${e.message}", e)
                _weatherState.value = null
            }
        }
    }
}
