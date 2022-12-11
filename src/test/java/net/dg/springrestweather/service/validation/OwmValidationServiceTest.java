package net.dg.springrestweather.service.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import javax.validation.ValidationException;
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
    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testInvalidTimeZoneField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    weatherData.setTimezone(null);
    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testInvalidWindSpeedField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    weatherData.setWind(Wind.builder().speed(0.0).build());
    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testInvalidPressureField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setPressure(null);
    weatherData.setMain(main);

    weatherData.setMain(Main.builder().pressure(null).build());
    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testInvalidHumidityField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    Main main = WeatherDataObjectMother.buildMain();
    main.setHumidity(null);
    weatherData.setMain(main);

    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testInvalidDescriptionField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();
    List<Weather> weather = WeatherDataObjectMother.buildWeatherList();
    weather.get(0).setDescription(null);
    weatherData.setWeather(weather);

    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testInvalidForecastField() {

    WeatherData weatherData = WeatherDataObjectMother.buildWeather();
    List<Weather> weather = WeatherDataObjectMother.buildWeatherList();
    weather.get(0).setMain(null);
    weatherData.setWeather(weather);

    assertThrows(ValidationException.class, () -> owmValidationService.validate(weatherData));
  }

  @Test
  void testValidFields() {
    WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    assertDoesNotThrow(() -> owmValidationService.validate(weatherData));
  }
}
