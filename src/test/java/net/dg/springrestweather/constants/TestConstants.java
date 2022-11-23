package net.dg.springrestweather.constants;

public class TestConstants {

  // Constants for building weather objects
  public static final Integer ID = 1;
  public static final Double LAT = 44.34;
  public static final Double LON = 10.99;
  public static final String TEST = "test";
  public static final Double DATA_DOUBLE = 25.0;
  public static final Integer DATA_INTEGER = 25;
  public static final String CITY = "Brasov";

  // Constants for endpoints
  public static final String BASE_ENDPOINT_PATH = "/weather";
  public static final String GET_CURRENT_WEATHER = "/api/current";
  public static final String GET_WEATHER_BASED_ON_CITY = "/api?city=brasov";
  public static final String CITY_REQUEST_PARAM = "city";
}
