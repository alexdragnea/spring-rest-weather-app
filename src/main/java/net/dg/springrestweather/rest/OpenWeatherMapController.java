package net.dg.springrestweather.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.OWMConvertedResponse;
import net.dg.springrestweather.model.owm.WeatherData;
import net.dg.springrestweather.service.converter.OWMResponseConverterService;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api")
public class OpenWeatherMapController {

  private final OpenWeatherMapServiceImpl openWeatherMapService;
  private final OWMResponseConverterService OWMResponseConverterService;

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
  public ResponseEntity<OWMConvertedResponse> getWeatherBasedOnCoordinates(
      @RequestParam String latitude, String longitude) {

    OWMConvertedResponse OWMConvertedResponseResponse =
        OWMResponseConverterService.converOWMResponse(
            openWeatherMapService.getWeatherBasedOnCoordinates(latitude, longitude));

    return ResponseEntity.ok(OWMConvertedResponseResponse);
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
  public ResponseEntity<OWMConvertedResponse> getWeatherBasedOnCity(@RequestParam String city) {

    OWMConvertedResponse OWMConvertedResponseResponse =
        OWMResponseConverterService.converOWMResponse(openWeatherMapService.getWeatherByCity(city));
    return ResponseEntity.ok(OWMConvertedResponseResponse);
  }
}
