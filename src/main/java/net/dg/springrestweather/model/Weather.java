package net.dg.springrestweather.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Weather implements Serializable {

  public Integer id;
  public String main;
  public String description;
  public String icon;
}
