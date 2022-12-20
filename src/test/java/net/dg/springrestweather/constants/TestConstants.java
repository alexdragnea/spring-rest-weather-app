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
  public static final Integer CODE = 200;

  // Constants for endpoints
  public static final String OWM_BASE_ENDPOINT_PATH = "/weather";
  public static final String THING_SPEAK_BASE_ENDPOINT_PATH = "/feeds.json";
  public static final String GET_CURRENT_WEATHER =
      "/api/coordinates?latitude=44.34?longitude=10.99";
  public static final String GET_WEATHER_BASED_ON_CITY = "/api?city=brasov";
  public static final String GET_THING_SPEAK_DATA = "/thingspeak/data";

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
  public static final String INVALID_WEATHER_DATA_TEMP =
      "Constraint validation: weatherData.main.temp cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_TEMP_MAX =
      "Constraint validation: weatherData.main.tempMax cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_TEMP_MIN =
      "Constraint validation: weatherData.main.tempMin cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_FEELS_LIKE =
      "Constraint validation: weatherData.main.feelsLike cannot be null or empty.";
  public static final String INVALID_WEATHER_DATA_CODE =
      "Constraint validation: weatherData.code cannot be null or empty.";

  public static final String INVALID_THING_SPEAK_OBJECT =
      "Constraint validation: thingSpeakResponse cannot be null or empty.";
  public static final String INVALID_THING_SPEAK_FIELD_1 =
      "Constraint validation: thingSpeakResponse.channel.field1 cannot be null or empty.";
  public static final String INVALID_THING_SPEAK_FIELD_2 =
      "Constraint validation: thingSpeakResponse.channel.field2 cannot be null or empty.";
  public static final String INVALID_THING_SPEAK_FIELD_3 =
      "Constraint validation: thingSpeakResponse.channel.field3 cannot be null or empty.";

  public static final String INVALID_THING_SPEAK_CREATED_AT =
      "Constraint validation: thingSpeakResponse.feeds.createdAt cannot be null or empty.";
}
