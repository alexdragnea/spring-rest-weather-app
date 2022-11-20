package net.dg.springrestweather.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
