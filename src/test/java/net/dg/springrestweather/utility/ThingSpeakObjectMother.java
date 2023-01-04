package net.dg.springrestweather.utility;

import java.util.Date;
import java.util.List;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.thingspeak.Channel;
import net.dg.springrestweather.model.thingspeak.Feed;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;

public class ThingSpeakObjectMother {

  public static ThingSpeakResponse buildThingSpeakResponse() {
    return ThingSpeakResponse.builder().channel(buildChannel()).feeds(List.of(buildFeed())).build();
  }

  public static Channel buildChannel() {
    return Channel.builder()
        .createdAt(new Date())
        .field1(String.valueOf(TestConstants.DATA_DOUBLE))
        .field2(String.valueOf(TestConstants.DATA_DOUBLE))
        .field3(String.valueOf(TestConstants.DATA_DOUBLE))
        .latitude(TestConstants.TEST)
        .longitude(TestConstants.TEST)
        .updatedAt(new Date())
        .lastEntryId(TestConstants.DATA_INTEGER)
        .name(TestConstants.TEST)
        .build();
  }

  public static Feed buildFeed() {
    return Feed.builder()
        .createdAt(new Date())
        .entryId(TestConstants.DATA_INTEGER)
        .field1(String.valueOf(TestConstants.DATA_DOUBLE))
        .field2(String.valueOf(TestConstants.DATA_DOUBLE))
        .field3(String.valueOf(TestConstants.DATA_DOUBLE))
        .build();
  }
}
