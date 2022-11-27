package net.dg.springrestweather.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Main implements Serializable {

  public Double temp;
  public Double feelsLike;
  public Double tempMin;
  public Double tempMax;
  public Integer pressure;
  public Integer humidity;
}
