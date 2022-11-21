package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Weather {

  public Integer id;
  public String main;
  public String description;
  public String icon;
}
