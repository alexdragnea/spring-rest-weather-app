package net.dg.springrestweather.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.ValidationException;
import net.dg.springrestweather.client.owm.OpenWeatherMapClient;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.service.converter.OwmResponseConverterService;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import net.dg.springrestweather.service.validation.OwmValidationService;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import net.dg.springrestweather.utility.WeatherOwmObjectMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(OpenWeatherMapController.class)
class OpenWeatherMapControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean OpenWeatherMapClient openWeatherMapClient;
  @MockBean OpenWeatherMapServiceImpl openWeatherService;
  @MockBean OwmResponseConverterService owmResponseConverterService;
  @MockBean OwmValidationService owmValidationService;

  @Test
  void testGetWeatherBasedOnCoordinates() throws Exception {

    when(openWeatherService.getWeatherBasedOnCoordinates(any(), any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());

    when(owmResponseConverterService.convertOWMResponse(any()))
        .thenReturn(WeatherOwmObjectMother.buildWeatherOWM());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(TestConstants.GET_CURRENT_WEATHER)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.city").isNotEmpty())
        .andExpect(jsonPath("$.city").value(TestConstants.CITY))
        .andExpect(jsonPath("$.timeZone").isNotEmpty())
        .andExpect(jsonPath("$.timeZone").value(TestConstants.TEST))
        .andExpect(jsonPath("$.forecast").isNotEmpty())
        .andExpect(jsonPath("$.forecast").value(TestConstants.TEST))
        .andExpect(jsonPath("$.temp").isNotEmpty())
        .andExpect(jsonPath("$.temp").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.temp_min").isNotEmpty())
        .andExpect(jsonPath("$.temp_min").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.temp_max").isNotEmpty())
        .andExpect(jsonPath("$.temp_max").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.feels_like").isNotEmpty())
        .andExpect(jsonPath("$.feels_like").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.windSpeed").isNotEmpty())
        .andExpect(jsonPath("$.windSpeed").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.pressure").isNotEmpty())
        .andExpect(jsonPath("$.pressure").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.humidity").isNotEmpty())
        .andExpect(jsonPath("$.humidity").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.desc").isNotEmpty())
        .andExpect(jsonPath("$.desc").value(TestConstants.TEST))
        .andExpect(jsonPath("$.code").isNotEmpty())
        .andExpect(jsonPath("$.code").value(TestConstants.DATA_INTEGER));
  }

  @Test
  void getWeatherBasedOnCity() throws Exception {

    when(openWeatherService.getWeatherByCity(any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());

    when(owmResponseConverterService.convertOWMResponse(any()))
        .thenReturn(WeatherOwmObjectMother.buildWeatherOWM());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(TestConstants.GET_WEATHER_BASED_ON_CITY)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.city").isNotEmpty())
        .andExpect(jsonPath("$.city").value(TestConstants.CITY))
        .andExpect(jsonPath("$.timeZone").isNotEmpty())
        .andExpect(jsonPath("$.timeZone").value(TestConstants.TEST))
        .andExpect(jsonPath("$.forecast").isNotEmpty())
        .andExpect(jsonPath("$.forecast").value(TestConstants.TEST))
        .andExpect(jsonPath("$.temp").isNotEmpty())
        .andExpect(jsonPath("$.temp").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.temp_min").isNotEmpty())
        .andExpect(jsonPath("$.temp_min").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.temp_max").isNotEmpty())
        .andExpect(jsonPath("$.temp_max").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.feels_like").isNotEmpty())
        .andExpect(jsonPath("$.feels_like").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.windSpeed").isNotEmpty())
        .andExpect(jsonPath("$.windSpeed").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.pressure").isNotEmpty())
        .andExpect(jsonPath("$.pressure").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.humidity").isNotEmpty())
        .andExpect(jsonPath("$.humidity").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.desc").isNotEmpty())
        .andExpect(jsonPath("$.desc").value(TestConstants.TEST))
        .andExpect(jsonPath("$.code").isNotEmpty())
        .andExpect(jsonPath("$.code").value(TestConstants.DATA_INTEGER));
  }

  @Test
  void getWeatherBasedOnCityWillCatchException() throws Exception {

    when(openWeatherService.getWeatherByCity(any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());

    when(owmResponseConverterService.convertOWMResponse(any()))
        .thenReturn(WeatherOwmObjectMother.buildWeatherOWM());

    doThrow(ValidationException.class).when(owmValidationService).validate(any());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(TestConstants.GET_WEATHER_BASED_ON_CITY)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isInternalServerError());
  }
}
