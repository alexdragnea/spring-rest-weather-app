
package net.dg.springrestweather.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sys {

    public Integer type;
    public Integer id;
    public String country;
    public Integer sunrise;
    public Integer sunset;

}
