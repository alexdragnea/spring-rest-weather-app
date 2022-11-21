package net.dg.springrestweather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Coord {

  public Double lon;
  public Double lat;
}
