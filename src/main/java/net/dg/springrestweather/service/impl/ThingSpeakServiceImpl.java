package net.dg.springrestweather.service.impl;

import net.dg.springrestweather.client.thingspeak.ThingSpeakClient;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import net.dg.springrestweather.service.ThingSpeakService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ThingSpeakServiceImpl implements ThingSpeakService {

  @Value("${thingSpeak.apiKey}")
  String apiKey;

  @Value("${thingSpeak.results}")
  String results;

  private ThingSpeakClient thingSpeakClient;

  public ThingSpeakServiceImpl(ThingSpeakClient thingSpeakClient) {
    this.thingSpeakClient = thingSpeakClient;
  }

  @Override
  public ThingSpeakResponse getData() {
    return thingSpeakClient.getData(apiKey, results);
  }
}
