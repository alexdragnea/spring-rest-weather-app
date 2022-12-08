package net.dg.springrestweather.service.converter;

import net.dg.springrestweather.model.owm.WeatherData;
import net.dg.springrestweather.model.WeatherOWMConvertedResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherOWMConverterService {

  public WeatherOWMConvertedResponse converOWMResponse(WeatherData weatherData) {

    double temperature_double_format = weatherData.getMain().getTemp();
    return WeatherOWMConvertedResponse.builder()
        .city(weatherData.getName())
        .timeZone(String.valueOf(weatherData.getTimezone()))
        .forecast(weatherData.getWeather().get(0).getMain())
        .temperature((int) (temperature_double_format))
        .windSpeed(weatherData.getWind().getSpeed())
        .pressure(weatherData.getMain().getPressure())
        .humidity(weatherData.getMain().getHumidity())
        .description(weatherData.getWeather().get(0).getDescription())
        .build();
  }
}
