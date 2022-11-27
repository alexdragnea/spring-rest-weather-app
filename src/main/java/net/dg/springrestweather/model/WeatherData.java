package net.dg.springrestweather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class WeatherData implements Serializable {

  public Coord coord;
  public List<Weather> weather = new ArrayList<Weather>();
  public String base;
  public Main main;
  public Integer visibility;
  public Wind wind;
  public Clouds clouds;
  public Integer dt;
  public Sys sys;
  public Integer timezone;
  public Integer id;
  public String name;
  public Integer cod;
}
