package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Sys implements Serializable {

  public Integer type;
  public Integer id;
  public String country;
  public Integer sunrise;
  public Integer sunset;
}
