package net.dg.springrestweather.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.ValidationException;
import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.owm.OwmConvertedResponse;
import net.dg.springrestweather.model.owm.WeatherData;
import net.dg.springrestweather.service.converter.OwmResponseConverterService;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import net.dg.springrestweather.service.validation.OwmValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api")
public class OpenWeatherMapController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapController.class);

  private final OpenWeatherMapServiceImpl openWeatherMapService;
  private final OwmResponseConverterService owmResponseConverterService;
  private final OwmValidationService owmValidationService;

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
  public ResponseEntity<OwmConvertedResponse> getWeatherBasedOnCoordinates(
      @RequestParam String latitude, String longitude) {

    OwmConvertedResponse owmConvertedResponse =
        owmResponseConverterService.convertOWMResponse(
            openWeatherMapService.getWeatherBasedOnCoordinates(latitude, longitude));

    return ResponseEntity.ok(owmConvertedResponse);
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
  public ResponseEntity<OwmConvertedResponse> getWeatherBasedOnCity(@RequestParam String city) {

    WeatherData weatherData = openWeatherMapService.getWeatherByCity(city);

    try {

      owmValidationService.validate(weatherData);

      OwmConvertedResponse owmConvertedResponse =
          owmResponseConverterService.convertOWMResponse(weatherData);

      return ResponseEntity.ok(owmConvertedResponse);

    } catch (ValidationException exception) {

      LOGGER.info(exception.getMessage());
      throw new ValidationException(exception.getMessage());
    }
  }
}
