package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Sys implements Serializable {

  private Integer type;
  private Integer id;
  private String country;
  private Integer sunrise;
  private Integer sunset;
}
