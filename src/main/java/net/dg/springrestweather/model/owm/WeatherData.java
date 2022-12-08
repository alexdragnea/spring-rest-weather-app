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

  private Coord coord;
  private List<Weather> weather;
  private String base;
  private Main main;
  private Integer visibility;
  private Wind wind;
  private Clouds clouds;
  private Integer dt;
  private Sys sys;
  private Integer timezone;
  private Integer id;
  private String name;
  private Integer cod;
}
