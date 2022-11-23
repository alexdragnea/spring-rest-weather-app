package net.dg.springrestweather.rest;

import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class OpenWeatherMapController {

  private final OpenWeatherMapServiceImpl openWeatherMapService;

  @GetMapping(value = "/current")
  public ResponseEntity<WeatherData> getCurrentWeather() {

    return ResponseEntity.ok(openWeatherMapService.getCurrenWeather());
  }

  @GetMapping
  public ResponseEntity<WeatherData> getWeatherBasedOnCity(@RequestParam String city) {

    return ResponseEntity.ok(openWeatherMapService.getWeatherByCity(city));
  }
}
