package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Wind {

  public Double speed;
  public Integer deg;
  public Double gust;
}
