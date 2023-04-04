package net.dg.springrestweather.service.converter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import net.dg.springrestweather.model.thingspeak.Feed;
import net.dg.springrestweather.model.thingspeak.ThingSpeakConvertedResponse;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ThingSpeakResponseConverterService {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(ThingSpeakResponseConverterService.class);

  private static final DecimalFormat df = new DecimalFormat("0.00");

  public ThingSpeakConvertedResponse convertThingSpeakResponse(
      ThingSpeakResponse thingSpeakResponse) {

    LOGGER.info(
        "Converting ThingSpeak object: {} to ThingSpeakConvertedResponse object.",
        thingSpeakResponse);

    List<Feed> feedList = new ArrayList<>();
    feedList = thingSpeakResponse.getFeeds();
    DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy hh:mm a");

    return ThingSpeakConvertedResponse.builder()
        .createdAt(dateFormat.format(thingSpeakResponse.getFeeds().get(0).getCreatedAt()))
        .temperature(feedList.get(0).getField1())
        .humidity(df.format(Double.valueOf(feedList.get(0).getField2())))
        .pressure(df.format(Double.valueOf(feedList.get(0).getField3())))
        .code(200)
        .build();
  }
}
