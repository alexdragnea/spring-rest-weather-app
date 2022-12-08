package net.dg.springrestweather.service.converter;

import net.dg.springrestweather.model.Main;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.model.WeatherOWM;
import org.springframework.stereotype.Service;

@Service
public class WeatherOWMConverterService {

  public WeatherOWM converOWMResponse(WeatherData weatherData) {

    double temperature_double_format = weatherData.getMain().getTemp();
    return WeatherOWM.builder()
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
