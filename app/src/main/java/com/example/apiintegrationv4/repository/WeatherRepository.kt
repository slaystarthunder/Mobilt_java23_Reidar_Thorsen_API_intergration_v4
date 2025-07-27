package com.example.apiintegrationv4.repository

import android.util.Log
import com.example.apiintegrationv4.api.WeatherApi

class WeatherRepository(private val api: WeatherApi) {

    suspend fun fetchWeather(city: String, apiKey: String) = try {
        Log.d("WeatherRepository", "Fetching weather for city: $city")
        val response = api.getWeather(city, apiKey)
        Log.d("WeatherRepository", "API Response: $response")
        response
    } catch (e: Exception) {
        Log.e("WeatherRepository", "Error fetching weather: ${e.message}", e)
        throw e
    }
}
