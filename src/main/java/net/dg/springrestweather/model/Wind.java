package net.dg.springrestweather.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Wind implements Serializable {

  public Double speed;
  public Integer deg;
  public Double gust;
}
