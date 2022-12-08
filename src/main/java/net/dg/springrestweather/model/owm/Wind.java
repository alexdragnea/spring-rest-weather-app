package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Wind implements Serializable {

  private Double speed;
  private Integer deg;
  private Double gust;
}
