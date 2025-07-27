package com.example.apiintegrationv4.api

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric" // For Celsius
    ): OpenWeatherResponse
}

data class OpenWeatherResponse(
    val main: Main
)

data class Main(
    val temp: Double
)
