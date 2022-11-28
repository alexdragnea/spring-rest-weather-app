package net.dg.springrestweather.service;

import net.dg.springrestweather.model.WeatherData;

public interface OpenWeatherMapService {

  WeatherData getWeatherBasedOnCoordinates(String latitude, String longitude);

  WeatherData getWeatherByCity(String city);
}
