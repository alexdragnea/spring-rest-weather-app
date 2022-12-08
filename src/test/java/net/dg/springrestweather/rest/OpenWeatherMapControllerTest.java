package net.dg.springrestweather.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import net.dg.springrestweather.client.OpenWeatherMapClient;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.service.converter.WeatherOWMConverterService;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import net.dg.springrestweather.utility.WeatherOWMObjectMother;
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
  @MockBean WeatherOWMConverterService weatherOWMConverterService;

  @Test
  void testGetWeatherBasedOnCoordinates() throws Exception {

    when(openWeatherService.getWeatherBasedOnCoordinates(any(), any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());

    when(weatherOWMConverterService.converOWMResponse(any()))
        .thenReturn(WeatherOWMObjectMother.buildWeatherOWM());

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
        .andExpect(jsonPath("$.temperature").isNotEmpty())
        .andExpect(jsonPath("$.temperature").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.windSpeed").isNotEmpty())
        .andExpect(jsonPath("$.windSpeed").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.pressure").isNotEmpty())
        .andExpect(jsonPath("$.pressure").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.humidity").isNotEmpty())
        .andExpect(jsonPath("$.humidity").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.description").isNotEmpty())
        .andExpect(jsonPath("$.description").value(TestConstants.TEST));
  }

  @Test
  void getWeatherBasedOnCity() throws Exception {

    when(openWeatherService.getWeatherByCity(any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());

    when(weatherOWMConverterService.converOWMResponse(any()))
        .thenReturn(WeatherOWMObjectMother.buildWeatherOWM());

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
        .andExpect(jsonPath("$.temperature").isNotEmpty())
        .andExpect(jsonPath("$.temperature").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.windSpeed").isNotEmpty())
        .andExpect(jsonPath("$.windSpeed").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.pressure").isNotEmpty())
        .andExpect(jsonPath("$.pressure").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.humidity").isNotEmpty())
        .andExpect(jsonPath("$.humidity").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.description").isNotEmpty())
        .andExpect(jsonPath("$.description").value(TestConstants.TEST));
  }
}
