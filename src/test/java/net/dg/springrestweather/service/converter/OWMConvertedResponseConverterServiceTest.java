package net.dg.springrestweather.service.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.OWMConvertedResponse;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OWMConvertedResponseConverterServiceTest {

  @InjectMocks private OWMResponseConverterService OWMResponseConverterService;

  @Test
  void testConvertSuccesfully() {
    OWMConvertedResponse OWMConvertedResponseConverted =
        OWMResponseConverterService.converOWMResponse(WeatherDataObjectMother.buildWeather());

    Assertions.assertAll(
        () -> assertNotNull(OWMConvertedResponseConverted),
        () -> assertEquals(TestConstants.CITY, OWMConvertedResponseConverted.getCity()),
        () ->
            assertEquals(
                String.valueOf(TestConstants.DATA_INTEGER),
                OWMConvertedResponseConverted.getTimeZone()),
        () -> assertEquals(TestConstants.TEST, OWMConvertedResponseConverted.getForecast()),
        () ->
            assertEquals(
                TestConstants.DATA_INTEGER, OWMConvertedResponseConverted.getTemperature()),
        () ->
            assertEquals(
                TestConstants.DATA_DOUBLE, OWMConvertedResponseConverted.getWindSpeed()),
        () -> assertEquals(TestConstants.TEST, OWMConvertedResponseConverted.getForecast()),
        () ->
            assertEquals(
                TestConstants.DATA_INTEGER, OWMConvertedResponseConverted.getPressure()),
        () ->
            assertEquals(
                TestConstants.DATA_INTEGER, OWMConvertedResponseConverted.getHumidity()),
        () ->
            assertEquals(
                TestConstants.TEST, OWMConvertedResponseConverted.getDescription()));
  }
}
