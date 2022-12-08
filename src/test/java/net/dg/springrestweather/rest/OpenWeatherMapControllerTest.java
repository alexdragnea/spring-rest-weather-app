package net.dg.springrestweather.rest;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OpenWeatherMapController.class)
class OpenWeatherMapControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean OpenWeatherMapClient openWeatherMapClient;
  @MockBean OpenWeatherMapServiceImpl openWeatherService;
  @MockBean
  WeatherOWMConverterService weatherOWMConverterService;

  @Test
  void testGetCurrentWeather() throws Exception {

    when(openWeatherService.getWeatherBasedOnCoordinates(any(), any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());

    when(weatherOWMConverterService.converOWMResponse(any())).thenReturn(WeatherOWMObjectMother.buildWeatherOWM());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(TestConstants.GET_CURRENT_WEATHER)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.coord").isNotEmpty())
        .andExpect(jsonPath("$.weather").isNotEmpty())
        .andExpect(jsonPath("$.base").isNotEmpty())
        .andExpect(jsonPath("$.main").isNotEmpty())
        .andExpect(jsonPath("$.visibility").isNotEmpty())
        .andExpect(jsonPath("$.wind").isNotEmpty())
        .andExpect(jsonPath("$.clouds").isNotEmpty())
        .andExpect(jsonPath("$.dt").isNotEmpty())
        .andExpect(jsonPath("$.sys").isNotEmpty())
        .andExpect(jsonPath("$.timezone").isNotEmpty())
        .andExpect(jsonPath("$.id").isNotEmpty())
        .andExpect(jsonPath("$.name").isNotEmpty())
        .andExpect(jsonPath("$.cod").isNotEmpty());
  }

  @Test
  void getWeatherBasedOnCity() throws Exception {

    when(openWeatherService.getWeatherByCity(any()))
        .thenReturn(WeatherDataObjectMother.buildWeather());


    when(weatherOWMConverterService.converOWMResponse(any())).thenReturn(WeatherOWMObjectMother.buildWeatherOWM());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api")
                .param(TestConstants.CITY_REQUEST_PARAM, TestConstants.CITY)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.city").isNotEmpty())
        .andExpect(jsonPath("$.city").value(TestConstants.CITY))
            .andExpect(jsonPath("$.timeZone").isNotEmpty())
        .andExpect(jsonPath("$.timeZone").value(TestConstants.TEST))
        .andExpect(jsonPath("$.forecast").isNotEmpty())
            .andExpect(jsonPath("$.forecast").value(TestConstants.TEST))
            .andExpect(jsonPath("$.temperature").isNotEmpty())
            .andExpect(jsonPath("$.temperature").value(TestConstants.DATA_INTEGER));
//        .andExpect(jsonPath("$.weather[0].icon").value(TestConstants.TEST))
//        .andExpect(jsonPath("$.base").isNotEmpty())
//        .andExpect(jsonPath("$.base").value(TestConstants.TEST))
//        .andExpect(jsonPath("$.main").isNotEmpty())
//        .andExpect(jsonPath("$.main.temp").value(TestConstants.DATA_DOUBLE))
//        .andExpect(jsonPath("$.main.tempMax").value(TestConstants.DATA_DOUBLE))
//        .andExpect(jsonPath("$.main.tempMin").value(TestConstants.DATA_DOUBLE))
//        .andExpect(jsonPath("$.main.feelsLike").value(TestConstants.DATA_DOUBLE))
//        .andExpect(jsonPath("$.main.pressure").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.main.humidity").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.visibility").isNotEmpty())
//        .andExpect(jsonPath("$.visibility").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.wind").isNotEmpty())
//        .andExpect(jsonPath("$.wind.speed").value(TestConstants.DATA_DOUBLE))
//        .andExpect(jsonPath("$.wind.deg").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.wind.gust").value(TestConstants.DATA_DOUBLE))
//        .andExpect(jsonPath("$.clouds").isNotEmpty())
//        .andExpect(jsonPath("$.clouds.all").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.dt").isNotEmpty())
//        .andExpect(jsonPath("$.dt").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.sys").isNotEmpty())
//        .andExpect(jsonPath("$.sys.type").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.sys.id").value(TestConstants.ID))
//        .andExpect(jsonPath("$.sys.country").value(TestConstants.TEST))
//        .andExpect(jsonPath("$.sys.sunrise").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.sys.sunset").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.timezone").isNotEmpty())
//        .andExpect(jsonPath("$.timezone").value(TestConstants.DATA_INTEGER))
//        .andExpect(jsonPath("$.id").isNotEmpty())
//        .andExpect(jsonPath("$.id").value(TestConstants.ID))
//        .andExpect(jsonPath("$.name").isNotEmpty())
//        .andExpect(jsonPath("$.name").value(TestConstants.CITY))
//        .andExpect(jsonPath("$.cod").isNotEmpty())
//        .andExpect(jsonPath("$.cod").value(TestConstants.DATA_INTEGER));
  }
}
