package net.dg.springrestweather.utility;

import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.OWMConvertedResponse;

public class WeatherOWMObjectMother {

  public static OWMConvertedResponse buildWeatherOWM() {
    return OWMConvertedResponse.builder()
        .city(TestConstants.CITY)
        .timeZone(TestConstants.TEST)
        .forecast(TestConstants.TEST)
        .temperature(TestConstants.DATA_INTEGER)
        .windSpeed(TestConstants.DATA_DOUBLE)
        .pressure(TestConstants.DATA_INTEGER)
        .humidity(TestConstants.DATA_INTEGER)
        .description(TestConstants.TEST)
        .build();
  }
}
