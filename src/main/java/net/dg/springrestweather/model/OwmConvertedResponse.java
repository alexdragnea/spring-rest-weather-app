package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OwmConvertedResponse {

  private String city;
  private String timeZone;
  private String forecast;
  private int temperature;
  private double windSpeed;
  private Integer pressure;
  private Integer humidity;
  private String description;
}
