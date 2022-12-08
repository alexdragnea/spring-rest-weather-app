package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Main implements Serializable {

  private Double temp;
  private Double feelsLike;
  private Double tempMin;
  private Double tempMax;
  private Integer pressure;
  private Integer humidity;
}
