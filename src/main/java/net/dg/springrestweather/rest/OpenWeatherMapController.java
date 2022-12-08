package net.dg.springrestweather.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.WeatherData;
import net.dg.springrestweather.model.WeatherOWM;
import net.dg.springrestweather.service.converter.WeatherOWMConverterService;
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
  private final WeatherOWMConverterService weatherOWMConverterService;

  @Operation(summary = "Get WeatherData based on coordinates")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "WeatherData found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = WeatherData.class))
            })
      })
  @GetMapping(value = "/coordinates")
  public ResponseEntity<WeatherData> getWeatherBasedOnCoordinates(
      @RequestParam String latitude, String longitude) {

    WeatherOWM weatherOWMResponse =
        weatherOWMConverterService.converOWMResponse(
            openWeatherMapService.getWeatherBasedOnCoordinates(latitude, longitude));

    return ResponseEntity.ok(
        openWeatherMapService.getWeatherBasedOnCoordinates(latitude, longitude));
  }

  @Operation(summary = "Get WeatherData based on city")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "WeatherData found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = WeatherData.class))
            })
      })
  @GetMapping
  public ResponseEntity<WeatherData> getWeatherBasedOnCity(@RequestParam String city) {

//    WeatherOWM weatherOWMResponse =
//        weatherOWMConverterService.converOWMResponse(openWeatherMapService.getWeatherByCity(city));
    return ResponseEntity.ok(openWeatherMapService.getWeatherByCity(city));
  }
}
