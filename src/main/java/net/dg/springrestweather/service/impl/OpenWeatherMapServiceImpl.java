package net.dg.springrestweather.service.impl;

import net.dg.springrestweather.client.OpenWeatherMapClient;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.service.OpenWeatherMapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

  @Value("${weather.apiKey}")
  String apiKey;

  OpenWeatherMapClient openWeatherMapClient;

  public OpenWeatherMapServiceImpl(OpenWeatherMapClient openWeatherMapClient) {
    this.openWeatherMapClient = openWeatherMapClient;
  }

  public WeatherData getWeatherBasedOnCoordinates(String latitude, String longitude) {
    return openWeatherMapClient.currentWeather(latitude, longitude, apiKey);
  }

  public WeatherData getWeatherByCity(String city) {

    return openWeatherMapClient.getWeatherByCity(city, apiKey);
  }
}
