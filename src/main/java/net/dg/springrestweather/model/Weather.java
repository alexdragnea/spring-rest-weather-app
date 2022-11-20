package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Weather {

  public Integer id;
  public String main;
  public String description;
  public String icon;
}
