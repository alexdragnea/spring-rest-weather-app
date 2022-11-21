package net.dg.springrestweather.rest;

import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class OpenWeatherMapController {

  private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapController.class);

  private final OpenWeatherMapServiceImpl weatherService;

  @GetMapping(value = "/current")
  public WeatherData getCurrentWeather() {
    return weatherService.getCurrenWeather();
  }
}
