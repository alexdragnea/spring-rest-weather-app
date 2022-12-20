package net.dg.springrestweather.model.thingspeak;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThingSpeakResponse {

  private Channel channel;
  private List<Feed> feeds;
}
