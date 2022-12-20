package net.dg.springrestweather.service.impl;

import net.dg.springrestweather.client.owm.OpenWeatherMapClient;
import net.dg.springrestweather.model.owm.WeatherData;
import net.dg.springrestweather.service.OpenWeatherMapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

  @Value("${weather.apiKey}")
  String apiKey;

  @Value("${weather.measurementType}")
  String measurementType;

  private OpenWeatherMapClient openWeatherMapClient;

  public OpenWeatherMapServiceImpl(OpenWeatherMapClient openWeatherMapClient) {
    this.openWeatherMapClient = openWeatherMapClient;
  }

  public WeatherData getWeatherBasedOnCoordinates(String latitude, String longitude) {
    return openWeatherMapClient.getWeatherBasedOnCoordinates(
        latitude, longitude, apiKey, measurementType);
  }

  public WeatherData getWeatherByCity(String city) {

    return openWeatherMapClient.getWeatherByCity(city, apiKey, measurementType);
  }
}
