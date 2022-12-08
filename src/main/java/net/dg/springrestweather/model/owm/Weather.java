package net.dg.springrestweather.model.owm;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Weather implements Serializable {

  private Integer id;
  private String main;
  private String description;
  private String icon;
}
