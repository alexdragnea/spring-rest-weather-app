package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OWMConvertedResponse {

  private String city;
  private String timeZone;
  private String forecast;
  private int temperature;
  private double windSpeed;
  private Integer pressure;
  private Integer humidity;
  private String description;
}
