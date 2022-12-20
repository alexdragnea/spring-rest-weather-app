package net.dg.springrestweather.utility;

import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.owm.OwmConvertedResponse;

public class WeatherOwmObjectMother {

  public static OwmConvertedResponse buildWeatherOWM() {
    return OwmConvertedResponse.builder()
        .city(TestConstants.CITY)
        .timeZone(TestConstants.TEST)
        .forecast(TestConstants.TEST)
        .feelsLike(TestConstants.DATA_DOUBLE)
        .temp(TestConstants.DATA_DOUBLE)
        .tempMax(TestConstants.DATA_DOUBLE)
        .tempMin(TestConstants.DATA_DOUBLE)
        .windSpeed(TestConstants.DATA_DOUBLE)
        .pressure(TestConstants.DATA_INTEGER)
        .humidity(TestConstants.DATA_INTEGER)
        .desc(TestConstants.TEST)
        .code(TestConstants.DATA_INTEGER)
        .build();
  }
}
