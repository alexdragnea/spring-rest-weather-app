package net.dg.springrestweather.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import net.dg.springrestweather.client.OpenWeatherMapClient;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
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

  @Test
  void testGetCurrentWeather() throws Exception {

    when(openWeatherService.getCurrenWeather()).thenReturn(WeatherDataObjectMother.buildWeather());

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

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api")
                .param(TestConstants.CITY_REQUEST_PARAM, TestConstants.CITY)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.coord").isNotEmpty())
        .andExpect(jsonPath("$.coord.lon").value(TestConstants.LON))
        .andExpect(jsonPath("$.coord.lat").value(TestConstants.LAT))
        .andExpect(jsonPath("$.weather").isNotEmpty())
        .andExpect(jsonPath("$.weather[0].id").value(TestConstants.ID))
        .andExpect(jsonPath("$.weather[0].main").value(TestConstants.TEST))
        .andExpect(jsonPath("$.weather[0].description").value(TestConstants.TEST))
        .andExpect(jsonPath("$.weather[0].icon").value(TestConstants.TEST))
        .andExpect(jsonPath("$.base").isNotEmpty())
        .andExpect(jsonPath("$.base").value(TestConstants.TEST))
        .andExpect(jsonPath("$.main").isNotEmpty())
        .andExpect(jsonPath("$.main.temp").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.main.tempMax").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.main.tempMin").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.main.feelsLike").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.main.pressure").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.main.humidity").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.visibility").isNotEmpty())
        .andExpect(jsonPath("$.visibility").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.wind").isNotEmpty())
        .andExpect(jsonPath("$.wind.speed").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.wind.deg").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.wind.gust").value(TestConstants.DATA_DOUBLE))
        .andExpect(jsonPath("$.clouds").isNotEmpty())
        .andExpect(jsonPath("$.clouds.all").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.dt").isNotEmpty())
        .andExpect(jsonPath("$.dt").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.sys").isNotEmpty())
        .andExpect(jsonPath("$.sys.type").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.sys.id").value(TestConstants.ID))
        .andExpect(jsonPath("$.sys.country").value(TestConstants.TEST))
        .andExpect(jsonPath("$.sys.sunrise").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.sys.sunset").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.timezone").isNotEmpty())
        .andExpect(jsonPath("$.timezone").value(TestConstants.DATA_INTEGER))
        .andExpect(jsonPath("$.id").isNotEmpty())
        .andExpect(jsonPath("$.id").value(TestConstants.ID))
        .andExpect(jsonPath("$.name").isNotEmpty())
        .andExpect(jsonPath("$.name").value(TestConstants.CITY))
        .andExpect(jsonPath("$.cod").isNotEmpty())
        .andExpect(jsonPath("$.cod").value(TestConstants.DATA_INTEGER));
  }
}
