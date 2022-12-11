package net.dg.springrestweather.service.validation;

import java.util.Objects;
import javax.validation.ValidationException;
import net.dg.springrestweather.constants.ServiceConstants;
import net.dg.springrestweather.model.owm.WeatherData;
import org.springframework.stereotype.Service;

@Service
public class OwmValidationService {

  public void validate(WeatherData weatherData) throws ValidationException {

    if (Objects.isNull(weatherData.getName())) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT, "weatherData.name cannot be null or empty"));
    }
    if (Objects.isNull(weatherData.getTimezone())) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT, "weatherData.timeZone cannot be null or empty"));
    }
    if (Objects.isNull(weatherData.getWeather().get(0).getMain())) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT,
              "weatherData.weather.main cannot be null or empty"));
    }
    if (weatherData.getWind().getSpeed() <= 0) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT,
              "weatherData.wind.windSpeed cannot be less or equal with 0"));
    }
    if (Objects.isNull(weatherData.getMain().getPressure())) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT,
              "weatherData.main.pressure cannot be null or empty"));
    }
    if (Objects.isNull(weatherData.getMain().getHumidity())) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT,
              "weatherData.main.humidity cannot be null or empty"));
    }

    if (Objects.isNull(weatherData.getWeather().get(0).getDescription())) {
      throw new ValidationException(
          String.format(
              ServiceConstants.VALIDATION_FORMAT,
              "weatherData.weather.description cannot be null or empty"));
    }
  }
}
