package net.dg.springrestweather.service.converter;

import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.WeatherOWMConvertedResponse;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class WeatherOWMConvertedResponseConverterServiceTest {

  @InjectMocks private WeatherOWMConverterService weatherOWMConverterService;

  @Test
  void testConvertSuccesfully() {
    WeatherOWMConvertedResponse weatherOWMConvertedResponseConverted =
        weatherOWMConverterService.converOWMResponse(WeatherDataObjectMother.buildWeather());

    Assertions.assertAll(
        () -> assertNotNull(weatherOWMConvertedResponseConverted),
        () -> assertEquals(TestConstants.CITY, weatherOWMConvertedResponseConverted.getCity()),
        () ->
            assertEquals(
                String.valueOf(TestConstants.DATA_INTEGER), weatherOWMConvertedResponseConverted.getTimeZone()),
        () -> assertEquals(TestConstants.TEST, weatherOWMConvertedResponseConverted.getForecast()),
        () -> assertEquals(TestConstants.DATA_INTEGER, weatherOWMConvertedResponseConverted.getTemperature()),
        () -> assertEquals(TestConstants.DATA_DOUBLE, weatherOWMConvertedResponseConverted.getWindSpeed()),
        () -> assertEquals(TestConstants.TEST, weatherOWMConvertedResponseConverted.getForecast()),
        () -> assertEquals(TestConstants.DATA_INTEGER, weatherOWMConvertedResponseConverted.getPressure()),
        () -> assertEquals(TestConstants.DATA_INTEGER, weatherOWMConvertedResponseConverted.getHumidity()),
        () -> assertEquals(TestConstants.TEST, weatherOWMConvertedResponseConverted.getDescription()));
  }
}
