package net.dg.springrestweather.client.owm;

import net.dg.springrestweather.model.owm.WeatherData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WeatherServiceClient", url = "${base.url.owm}", decode404 = true)
public interface OpenWeatherMapClient {

  @GetMapping(value = "/weather")
  WeatherData getWeatherBasedOnCoordinates(
      @RequestParam("lat") String lat,
      @RequestParam("lon") String lon,
      @RequestParam("appid") String apiKey,
      @RequestParam("units") String measurementType);

  @GetMapping(value = "/weather")
  WeatherData getWeatherByCity(
      @RequestParam("q") String city,
      @RequestParam("appid") String apiKey,
      @RequestParam("units") String measurementType);
}
