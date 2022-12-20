package net.dg.springrestweather.model.thingspeak;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ThingSpeakConvertedResponse {

  @JsonProperty("created_at")
  private String createdAt;

  private String temperature;
  private String humidity;
  private String pressure;
  private Integer code;
}
