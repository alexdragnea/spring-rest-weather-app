package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WeatherData implements Serializable {

  public Coord coord;
  public List<Weather> weather;
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
