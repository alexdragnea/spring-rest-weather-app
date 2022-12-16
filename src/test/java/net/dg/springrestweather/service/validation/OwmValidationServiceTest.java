package net.dg.springrestweather.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import javax.validation.ValidationException;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.owm.Main;
import net.dg.springrestweather.model.owm.Weather;
import net.dg.springrestweather.model.owm.WeatherData;
import net.dg.springrestweather.model.owm.Wind;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwmValidationServiceTest {

  @InjectMocks private OwmValidationService owmValidationService;

  @Test
  void testInvalidNameField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    weatherData.setName(null);
    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_NAME, ex.getMessage());
  }

  @Test
  void testInvalidTimeZoneField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    weatherData.setTimezone(null);
    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_TIMEZONE, ex.getMessage());
  }

  @Test
  void testInvalidWindSpeedField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    weatherData.setWind(Wind.builder().speed(0.0).build());
    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_WIND_WINDSPEED, ex.getMessage());
  }

  @Test
  void testInvalidTemperatureField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setTemp(null);
    weatherData.setMain(main);
    Throwable ex =
            assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_TEMP, ex.getMessage());
  }

  @Test
  void testInvalidMaxTempField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setTempMax(null);
    weatherData.setMain(main);
    Throwable ex =
            assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_TEMP_MAX, ex.getMessage());
  }

  @Test
  void testInvalidMinTempField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setTempMin(null);
    weatherData.setMain(main);
    Throwable ex =
            assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_TEMP_MIN, ex.getMessage());
  }

  @Test
  void testInvalidFeelsLikeField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setFeelsLike(null);
    weatherData.setMain(main);
    Throwable ex =
            assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_FEELS_LIKE, ex.getMessage());
  }

  @Test
  void testInvalidPressureField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setPressure(null);
    weatherData.setMain(main);

    weatherData.setMain(Main.builder().pressure(null).build());
    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_MAIN_PRESSURE, ex.getMessage());
  }

  @Test
  void testInvalidHumidityField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setHumidity(null);
    weatherData.setMain(main);

    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_MAIN_HUMIDITY, ex.getMessage());
  }

  @Test
  void testInvalidDescriptionField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();
    List<Weather> weather = WeatherDataObjectMother.buildWeatherList();
    weather.get(0).setDescription(null);
    weatherData.setWeather(weather);

    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_WEATHER_DESCRIPTION, ex.getMessage());
  }

  @Test
  void testInvalidCodeField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();
    weatherData.setCod(null);

    Throwable ex =
            assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_CODE, ex.getMessage());
  }

  @Test
  void testInvalidForecastField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();
    List<Weather> weather = WeatherDataObjectMother.buildWeatherList();
    weather.get(0).setMain(null);
    weatherData.setWeather(weather);

    Throwable ex =
        assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
    assertEquals(TestConstants.INVALID_WEATHER_DATA_MAIN, ex.getMessage());
  }

  @Test
  void testValidFields() {
    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    assertDoesNotThrow(() -> owmValidationService.validate(weatherData));
  }
}
