package net.dg.springrestweather.service.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.OwmConvertedResponse;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwmConvertedResponseConverterServiceTest {

  @InjectMocks private OwmResponseConverterService OWMResponseConverterService;

  @Test
  void testConvertSuccesfully() {
    OwmConvertedResponse OwmConvertedResponseConverted =
        OWMResponseConverterService.converOWMResponse(WeatherDataObjectMother.buildWeather());

    Assertions.assertAll(
        () -> assertNotNull(OwmConvertedResponseConverted),
        () -> assertEquals(TestConstants.CITY, OwmConvertedResponseConverted.getCity()),
        () ->
            assertEquals(
                String.valueOf(TestConstants.DATA_INTEGER),
                OwmConvertedResponseConverted.getTimeZone()),
        () -> assertEquals(TestConstants.TEST, OwmConvertedResponseConverted.getForecast()),
        () ->
            assertEquals(
                TestConstants.DATA_INTEGER, OwmConvertedResponseConverted.getTemperature()),
        () -> assertEquals(TestConstants.DATA_DOUBLE, OwmConvertedResponseConverted.getWindSpeed()),
        () -> assertEquals(TestConstants.TEST, OwmConvertedResponseConverted.getForecast()),
        () -> assertEquals(TestConstants.DATA_INTEGER, OwmConvertedResponseConverted.getPressure()),
        () -> assertEquals(TestConstants.DATA_INTEGER, OwmConvertedResponseConverted.getHumidity()),
        () -> assertEquals(TestConstants.TEST, OwmConvertedResponseConverted.getDescription()));
  }
}
