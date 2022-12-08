package net.dg.springrestweather.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OWMConvertedResponse {

  public String city;
  public String timeZone;
  public String forecast;
  public int temperature;
  public double windSpeed;
  public Integer pressure;
  public Integer humidity;
  public String description;
}
