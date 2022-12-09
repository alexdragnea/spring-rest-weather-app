package net.dg.springrestweather.wiremock.feign;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import net.dg.springrestweather.client.OpenWeatherMapClient;
import net.dg.springrestweather.client.errordecoder.FeignErrorDecoder;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.owm.WeatherData;
import net.dg.springrestweather.utility.WeatherDataObjectMother;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TestOpenWeaterMapClient {

  @Autowired MockMvc mockMvc;

  @Autowired private static WireMockServer wireMockServer;

  @Autowired private ObjectMapper objectMapper;

  @Autowired private OpenWeatherMapClient openWeatherMapClient;

  @Autowired private FeignErrorDecoder feignErrorDecoder;

  @BeforeAll
  static void initMockServer() {
    wireMockServer = new WireMockServer(new WireMockConfiguration().port(7777));
    wireMockServer.start();
    WireMock.configureFor("localhost", 7777);
  }

  @BeforeEach
  void resetWiremock() {
    wireMockServer.resetAll();
  }

  @AfterAll
  static void stop() {
    wireMockServer.stop();
  }

  @Test
  void testCallGetWeatherByLatAndLon() throws Exception {
    happyFlowStub();

    mockMvc.perform(get(TestConstants.GET_CURRENT_WEATHER)).andExpect(status().isOk());

    verify(getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetWeatherByCity() throws Exception {
    happyFlowStub();

    mockMvc.perform(get(TestConstants.GET_WEATHER_BASED_ON_CITY)).andExpect(status().isOk());

    verify(getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetWeatherByCityRetryingFor408Status() throws Exception {
    timeoutStub();

    mockMvc
        .perform(get(TestConstants.GET_WEATHER_BASED_ON_CITY))
        .andExpect(status().isServiceUnavailable());

    verify(4, getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetWeatherByCityRetryingFor503Status() throws Exception {
    serviceUnavailableStub();

    mockMvc
        .perform(get(TestConstants.GET_WEATHER_BASED_ON_CITY))
        .andExpect(status().isServiceUnavailable());

    verify(4, getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetWeatherByCoordinatesRetryingFor408Status() throws Exception {
    serviceUnavailableStub();

    mockMvc
        .perform(get(TestConstants.GET_CURRENT_WEATHER))
        .andExpect(status().isServiceUnavailable());

    verify(4, getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetWeatherByCoordinatesRetryingFor503Status() throws Exception {
    serviceUnavailableStub();

    mockMvc
        .perform(get(TestConstants.GET_CURRENT_WEATHER))
        .andExpect(status().isServiceUnavailable());

    verify(4, getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  }

  void happyFlowStub() {

    final WeatherData weatherData = WeatherDataObjectMother.buildWeather();

    JsonNode node = objectMapper.convertValue(weatherData, JsonNode.class);

    stubFor(
        WireMock.get(urlPathMatching(TestConstants.BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withJsonBody(node)));
  }

  void timeoutStub() {

    stubFor(
        WireMock.get(urlPathMatching(TestConstants.BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.REQUEST_TIMEOUT.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));
  }

  void serviceUnavailableStub() {

    stubFor(
        WireMock.get(urlPathMatching(TestConstants.BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.SERVICE_UNAVAILABLE.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));
  }
}
