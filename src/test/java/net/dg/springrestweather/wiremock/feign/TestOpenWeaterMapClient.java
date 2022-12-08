package net.dg.springrestweather.wiremock.feign;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TestOpenWeaterMapClient {
  //
  //  private static WireMockServer wireMockServer;
  //
  //  @Autowired private MockMvc mockMvc;
  //
  //  @Autowired private WeatherOWMConverterService weatherOWMConverterService;
  //
  //  @Autowired private OpenWeatherMapServiceImpl openWeatherMapService;
  //
  //  @BeforeAll
  //  static void init() {
  //    wireMockServer = new WireMockServer(new WireMockConfiguration().port(7070));
  //    wireMockServer.start();
  //    WireMock.configureFor("localhost", 7070);
  //  }
  //
  //  @AfterAll
  //  static void stop() {
  //    wireMockServer.stop();
  //  }
  //
  //  @Test
  //  void testCallGetWeatherByLatAndLon() throws Exception {
  //    stubFor(
  //        WireMock.get(urlMatching(TestConstants.BASE_ENDPOINT_PATH))
  //            .willReturn(
  //                aResponse()
  //                    .withBody(String.valueOf(WeatherOWMObjectMother.buildWeatherOWM()))
  //                    .withStatus(HttpStatus.OK.ordinal())
  //                    .withHeader("Content-Type", ContentType.APPLICATION_JSON.toString())));
  //
  //    mockMvc.perform(get(TestConstants.GET_CURRENT_WEATHER)).andExpect(status().isOk());
  //
  //    verify(getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  //  }
  //
  //  @Test
  //  void testCallGetWeatherByCity() throws Exception {
  //    stubFor(
  //        WireMock.get(urlMatching(TestConstants.BASE_ENDPOINT_PATH))
  //            .willReturn(
  //                aResponse()
  //                    .withStatus(HttpStatus.OK.ordinal())
  //                    .withHeader("Content-Type", ContentType.APPLICATION_JSON.toString())));
  //
  //    mockMvc.perform(get(TestConstants.GET_WEATHER_BASED_ON_CITY)).andExpect(status().isOk());
  //
  //    verify(getRequestedFor(urlPathEqualTo(TestConstants.BASE_ENDPOINT_PATH)));
  //  }
}
