package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Wind {

  public Double speed;
  public Integer deg;
  public Double gust;
}
