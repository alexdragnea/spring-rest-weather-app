package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Main implements Serializable {

  public Double temp;
  public Double feelsLike;
  public Double tempMin;
  public Double tempMax;
  public Integer pressure;
  public Integer humidity;
}
