package net.dg.springrestweather.wiremock.feign;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.service.converter.WeatherOWMConverterService;
import net.dg.springrestweather.service.impl.OpenWeatherMapServiceImpl;
import net.dg.springrestweather.utility.WeatherOWMObjectMother;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TestOpenWeaterMapClient {

  private static WireMockServer wireMockServer;

  @Autowired private MockMvc mockMvc;

  @Autowired private WeatherOWMConverterService weatherOWMConverterService;

  @Autowired private OpenWeatherMapServiceImpl openWeatherMapService;

  @BeforeAll
  static void init() {
    wireMockServer = new WireMockServer(new WireMockConfiguration().port(7070));
    wireMockServer.start();
    WireMock.configureFor("localhost", 7070);
  }

  @AfterAll
  static void stop() {
    wireMockServer.stop();
  }

  @Test
  void testCallGetWeatherByLatAndLon() throws Exception {
    stubFor(
        WireMock.get(urlMatching(TestConstants.BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withBody(String.valueOf(WeatherOWMObjectMother.buildWeatherOWM()))
                    .withStatus(HttpStatus.OK.ordinal())
                    .withHeader("Content-Type", ContentType.APPLICATION_JSON.toString())));

    mockMvc.perform(get(TestConstants.GET_CURRENT_WEATHER)).andExpect(status().isOk());

    verify(getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetWeatherByCity() throws Exception {
    stubFor(
        WireMock.get(urlMatching(TestConstants.BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.ordinal())
                    .withHeader("Content-Type", ContentType.APPLICATION_JSON.toString())));

    mockMvc.perform(get(TestConstants.GET_WEATHER_BASED_ON_CITY)).andExpect(status().isOk());

    verify(getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }
}
