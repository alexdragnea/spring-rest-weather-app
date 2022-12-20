package net.dg.springrestweather.wiremock.feign;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import net.dg.springrestweather.client.errordecoder.FeignErrorDecoder;
import net.dg.springrestweather.client.thingspeak.ThingSpeakClient;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import net.dg.springrestweather.service.impl.ThingSpeakServiceImpl;
import net.dg.springrestweather.utility.ThingSpeakObjectMother;
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
public class TestThingSpeakClient {

  @Autowired MockMvc mockMvc;

  @Autowired private static WireMockServer wireMockServer;

  @Autowired private ObjectMapper objectMapper;

  @Autowired private ThingSpeakClient thingSpeakClient;

  @Autowired private FeignErrorDecoder feignErrorDecoder;

  @Autowired private ThingSpeakServiceImpl thingSpeakService;

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
  void testCallGetThingSpeakData() throws Exception {
    happyFlowStub();

    mockMvc.perform(get(TestConstants.GET_THING_SPEAK_DATA)).andExpect(status().isOk());

    verify(getRequestedFor(urlPathEqualTo(TestConstants.THING_SPEAK_BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetThingSpeakDataRetryFor408Status() throws Exception {
    timeoutStub();

    mockMvc
        .perform(get(TestConstants.GET_THING_SPEAK_DATA))
        .andExpect(status().isServiceUnavailable());

    verify(4, getRequestedFor(urlPathEqualTo(TestConstants.THING_SPEAK_BASE_ENDPOINT_PATH)));
  }

  @Test
  void testCallGetThingSpeakDataRetryFor503Status() throws Exception {
    serviceUnavailableStub();

    mockMvc
        .perform(get(TestConstants.GET_THING_SPEAK_DATA))
        .andExpect(status().isServiceUnavailable());

    verify(4, getRequestedFor(urlPathEqualTo(TestConstants.THING_SPEAK_BASE_ENDPOINT_PATH)));
  }

  void happyFlowStub() {

    final ThingSpeakResponse thingSpeakResponse = ThingSpeakObjectMother.buildThingSpeakResponse();

    JsonNode node = objectMapper.convertValue(thingSpeakResponse, JsonNode.class);

    stubFor(
        WireMock.get(urlPathMatching(TestConstants.THING_SPEAK_BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withJsonBody(node)));
  }

  void timeoutStub() {

    stubFor(
        WireMock.get(urlPathMatching(TestConstants.THING_SPEAK_BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.REQUEST_TIMEOUT.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));
  }

  void serviceUnavailableStub() {

    stubFor(
        WireMock.get(urlPathMatching(TestConstants.THING_SPEAK_BASE_ENDPOINT_PATH))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.SERVICE_UNAVAILABLE.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));

    Thread.interrupted();
  }
}
