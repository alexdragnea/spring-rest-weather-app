package net.dg.springrestweather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  private double temp;

  @JsonProperty("feels_like")
  private Double feelsLike;

  @JsonProperty("temp_min")
  private Double tempMin;

  @JsonProperty("temp_max")
  private Double tempMax;

  private double windSpeed;
  private Integer pressure;
  private Integer humidity;
  private String desc;
  private Integer code;
}
