package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Main {

  public Double temp;
  public Double feelsLike;
  public Double tempMin;
  public Double tempMax;
  public Integer pressure;
  public Integer humidity;
}
