package net.dg.springrestweather.utility;

import java.util.List;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.owm.*;

public class WeatherDataObjectMother {

  public static WeatherData buildWeather() {
    return WeatherData.builder()
        .coord(buildCoord())
        .weather(buildWeatherList())
        .base(TestConstants.TEST)
        .main(buildMain())
        .visibility(TestConstants.DATA_INTEGER)
        .wind(buildWind())
        .clouds(buildClouds())
        .dt(TestConstants.DATA_INTEGER)
        .sys(buildSys())
        .timezone(TestConstants.DATA_INTEGER)
        .id(TestConstants.ID)
        .name(TestConstants.CITY)
        .cod(TestConstants.DATA_INTEGER)
        .build();
  }

  public static Coord buildCoord() {
    return Coord.builder().lat(TestConstants.LAT).lon(TestConstants.LON).build();
  }

  public static List<Weather> buildWeatherList() {
    return List.of(
        Weather.builder()
            .id(1)
            .main(TestConstants.TEST)
            .description(TestConstants.TEST)
            .icon(TestConstants.TEST)
            .build());
  }

  public static Main buildMain() {
    return Main.builder()
        .temp(TestConstants.DATA_DOUBLE)
        .tempMax(TestConstants.DATA_DOUBLE)
        .tempMin(TestConstants.DATA_DOUBLE)
        .feelsLike(TestConstants.DATA_DOUBLE)
        .pressure(TestConstants.DATA_INTEGER)
        .humidity(TestConstants.DATA_INTEGER)
        .build();
  }

  public static Wind buildWind() {
    return Wind.builder()
        .speed(TestConstants.DATA_DOUBLE)
        .deg(TestConstants.DATA_INTEGER)
        .gust(TestConstants.DATA_DOUBLE)
        .build();
  }

  public static Clouds buildClouds() {
    return Clouds.builder().all(TestConstants.DATA_INTEGER).build();
  }

  public static Sys buildSys() {
    return Sys.builder()
        .type(TestConstants.DATA_INTEGER)
        .id(TestConstants.ID)
        .country(TestConstants.TEST)
        .sunrise(TestConstants.DATA_INTEGER)
        .sunset(TestConstants.DATA_INTEGER)
        .build();
  }
}
