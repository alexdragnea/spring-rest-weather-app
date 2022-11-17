package net.dg.springrestweather.rest;

import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class WeatherController {

  private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

  private final WeatherService weatherService;

  @GetMapping(value = "/current")
  public WeatherData getCurrentWeather() {
    return weatherService.getCurrenWeather();
  }
}
