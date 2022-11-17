package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Weather {

  public Integer id;
  public String main;
  public String description;
  public String icon;
}
