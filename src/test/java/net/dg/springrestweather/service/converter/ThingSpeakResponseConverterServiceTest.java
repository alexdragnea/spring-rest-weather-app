package net.dg.springrestweather.service.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.thingspeak.ThingSpeakConvertedResponse;
import net.dg.springrestweather.utility.ThingSpeakObjectMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ThingSpeakResponseConverterServiceTest {

  @InjectMocks private ThingSpeakResponseConverterService thingSpeakResponseConverterService;

  @Test
  void testConvertSuccesfully() {
    ThingSpeakConvertedResponse thingSpeakConvertedResponse =
        thingSpeakResponseConverterService.convertThingSpeakResponse(
            ThingSpeakObjectMother.buildThingSpeakResponse());

    DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

    Assertions.assertAll(
        () -> assertNotNull(thingSpeakConvertedResponse),
        () -> assertEquals(TestConstants.CODE, thingSpeakConvertedResponse.getCode()),
        () -> assertEquals(TestConstants.TEST, thingSpeakConvertedResponse.getHumidity()),
        () -> assertEquals(TestConstants.TEST, thingSpeakConvertedResponse.getPressure()),
        () -> assertEquals(TestConstants.TEST, thingSpeakConvertedResponse.getTemperature()),
        () ->
            assertEquals(
                String.valueOf(dateFormat.format(new Date())),
                thingSpeakConvertedResponse.getCreatedAt()));
  }
}
