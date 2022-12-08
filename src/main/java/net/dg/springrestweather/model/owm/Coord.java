package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Coord implements Serializable {

  private Double lon;
  private Double lat;
}
