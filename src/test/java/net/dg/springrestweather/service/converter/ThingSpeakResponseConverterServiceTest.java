package net.dg.springrestweather.service.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.DecimalFormat;
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

    DecimalFormat df = new DecimalFormat("0.00");
    DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

    Assertions.assertAll(
        () -> assertNotNull(thingSpeakConvertedResponse),
        () -> assertEquals(TestConstants.CODE, thingSpeakConvertedResponse.getCode()),
        () ->
            assertEquals(
                df.format(Double.valueOf(TestConstants.DATA_DOUBLE)),
                thingSpeakConvertedResponse.getHumidity()),
        () ->
            assertEquals(
                df.format(Double.valueOf(TestConstants.DATA_DOUBLE)),
                thingSpeakConvertedResponse.getPressure()),
        () ->
            assertEquals(
                String.valueOf(TestConstants.DATA_DOUBLE),
                thingSpeakConvertedResponse.getTemperature()),
        () ->
            assertEquals(
                String.valueOf(dateFormat.format(new Date())),
                thingSpeakConvertedResponse.getCreatedAt()));
  }
}
