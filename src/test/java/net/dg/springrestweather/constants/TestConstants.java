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
  public static final String GET_CURRENT_WEATHER =
      "/api/coordinates?latitude=44.34?longitude=10.99";
  public static final String GET_WEATHER_BASED_ON_CITY = "/api?city=brasov";

  // Archunit

  public static final String BASE_PACKAGE = "net.dg.springrestweather";
  public static final String SERVICE_PACKAGE = "..service..";
  public static final String SERVICE_IMPL_PACKAGE = "..service..";
  public static final String CONTROLLER_PACKAGE = "..rest..";
  public static final String CLIENT_PACKAGE = "..client";
  public static final String CONFIG_PACKAGE = "..config..";
  public static final String CONTROLLER_LAYER = "Controller";
  public static final String SERVICE_LAYER = "Service";
  public static final String SERVICE_IMPL_LAYER = "ServiceImpl";

  // Exceptions

  public static final String RETRYABLE_RESPONSE_EXCEPTION_MESSAGE =
      "Service unavailable at the moment, please try again later.";

  // Validation messages

  public static final String INVALID_WEATHER_DATA_NAME =
      "Constraint validation: weatherData.name cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_WEATHER_DESCRIPTION =
      "Constraint validation: weatherData.weather.description cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_MAIN =
      "Constraint validation: weatherData.weather.main cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_MAIN_HUMIDITY =
      "Constraint validation: weatherData.main.humidity cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_MAIN_PRESSURE =
      "Constraint validation: weatherData.main.pressure cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_TIMEZONE =
      "Constraint validation: weatherData.timeZone cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_WIND_WINDSPEED =
      "Constraint validation: weatherData.wind.windSpeed cannot be less or equal with 0.";
}
