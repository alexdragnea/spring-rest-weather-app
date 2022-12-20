package net.dg.springrestweather.utility;

import java.util.Date;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.thingspeak.ThingSpeakConvertedResponse;

public class ThingSpeakConvertedResponseObjectMother {

  public static ThingSpeakConvertedResponse buildConvertedResponse() {
    return ThingSpeakConvertedResponse.builder()
        .temperature(TestConstants.TEST)
        .pressure(TestConstants.TEST)
        .humidity(TestConstants.TEST)
        .createdAt(String.valueOf(new Date()))
        .code(TestConstants.CODE)
        .build();
  }
}
