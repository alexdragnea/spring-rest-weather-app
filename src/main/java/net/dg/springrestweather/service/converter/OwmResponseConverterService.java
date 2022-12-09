package net.dg.springrestweather.service.converter;

import net.dg.springrestweather.model.OwmConvertedResponse;
import net.dg.springrestweather.model.owm.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OwmResponseConverterService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OwmResponseConverterService.class);

  public OwmConvertedResponse convertOWMResponse(WeatherData weatherData) {

    double temperature = weatherData.getMain().getTemp();

    LOGGER.info("Converting WeatherData object: {} to OwmConvertedResponse object.", weatherData);

    return OwmConvertedResponse.builder()
        .city(weatherData.getName())
        .timeZone(String.valueOf(weatherData.getTimezone()))
        .forecast(weatherData.getWeather().get(0).getMain())
        .temperature((int) (temperature))
        .windSpeed(weatherData.getWind().getSpeed())
        .pressure(weatherData.getMain().getPressure())
        .humidity(weatherData.getMain().getHumidity())
        .description(weatherData.getWeather().get(0).getDescription())
        .build();
  }
}
