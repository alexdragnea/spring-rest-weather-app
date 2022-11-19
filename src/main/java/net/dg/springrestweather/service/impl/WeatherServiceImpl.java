package net.dg.springrestweather.service.impl;

import net.dg.springrestweather.client.WeatherServiceClient;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.rest.WeatherController;
import net.dg.springrestweather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

  private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

  @Value("${weather.apiKey}")
  String apiKey;

  @Value("${weather.latitude}")
  String latitude;

  @Value("${weather.longitude}")
  String longitude;

  @Autowired WeatherServiceClient weatherServiceClient;

  public WeatherData getCurrenWeather() {
    logger.info(
        "Asking current weather to provider for coordinates [lat = {}, lon = {}]",
        latitude,
        longitude);
    return weatherServiceClient.currentWeather(latitude, longitude, apiKey);
  }
}
