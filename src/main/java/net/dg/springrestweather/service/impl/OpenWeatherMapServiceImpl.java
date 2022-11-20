package net.dg.springrestweather.service.impl;

import net.dg.springrestweather.client.OpenWeatherMapClient;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.service.OpenWeatherMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

  private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapServiceImpl.class);

  @Value("${weather.apiKey}")
  String apiKey;

  @Value("${weather.latitude}")
  String latitude;

  @Value("${weather.longitude}")
  String longitude;

  @Autowired OpenWeatherMapClient openWeatherMapClient;

  public WeatherData getCurrenWeather() {
    logger.info(
        "Asking current weather to provider for coordinates [lat = {}, lon = {}]",
        latitude,
        longitude);
    return openWeatherMapClient.currentWeather(latitude, longitude, apiKey);
  }
}
