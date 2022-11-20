package net.dg.springrestweather.client;

import net.dg.springrestweather.model.WeatherData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WeatherServiceClient", url = "https://api.openweathermap.org/data/2.5/")
public interface OpenWeatherMapClient {

  @GetMapping(value = "/weather")
  WeatherData currentWeather(
      @RequestParam("lat") String lat,
      @RequestParam("lon") String lon,
      @RequestParam("appid") String apiKey);
}
