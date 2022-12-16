package net.dg.springrestweather.model.owm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Main implements Serializable {

  private Double temp;

  @JsonProperty("feels_like")
  private Double feelsLike;

  @JsonProperty("temp_min")
  private Double tempMin;

  @JsonProperty("temp_max")
  private Double tempMax;
  private Integer pressure;
  private Integer humidity;
}
