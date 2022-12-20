package net.dg.springrestweather.rest;

import lombok.AllArgsConstructor;
import net.dg.springrestweather.model.thingspeak.ThingSpeakConvertedResponse;
import net.dg.springrestweather.service.converter.ThingSpeakResponseConverterService;
import net.dg.springrestweather.service.impl.ThingSpeakServiceImpl;
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

  @GetMapping(value = "/data")
  public ResponseEntity<ThingSpeakConvertedResponse> getData() {

    return ResponseEntity.ok(
        thingSpeakResponseConverterService.convertThingSpeakResponse(thingSpeakService.getData()));
  }
}
