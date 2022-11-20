package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Sys {

  public Integer type;
  public Integer id;
  public String country;
  public Integer sunrise;
  public Integer sunset;
}
