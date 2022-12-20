package net.dg.springrestweather.rest;

import javax.validation.ValidationException;
import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.thingspeak.ThingSpeakConvertedResponse;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import net.dg.springrestweather.service.converter.ThingSpeakResponseConverterService;
import net.dg.springrestweather.service.impl.ThingSpeakServiceImpl;
import net.dg.springrestweather.service.validation.ThingSpeakValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/thingspeak")
public class ThingSpeakController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ThingSpeakController.class);

  private final ThingSpeakServiceImpl thingSpeakService;
  private final ThingSpeakResponseConverterService thingSpeakResponseConverterService;
  private final ThingSpeakValidationService thingSpeakValidationService;

  @GetMapping(value = "/data")
  public ResponseEntity<ThingSpeakConvertedResponse> getData() {

    ThingSpeakResponse thingSpeakResponse = thingSpeakService.getData();

    try {

      thingSpeakValidationService.validate(thingSpeakResponse);
      return ResponseEntity.ok(
          thingSpeakResponseConverterService.convertThingSpeakResponse(thingSpeakResponse));
    } catch (ValidationException exception) {

      LOGGER.info(exception.getMessage());
      throw new ValidationException(exception.getMessage());
    }
  }
}
