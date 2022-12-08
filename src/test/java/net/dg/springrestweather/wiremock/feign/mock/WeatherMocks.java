package net.dg.springrestweather.wiremock.feign.mock;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import java.io.IOException;
import net.dg.springrestweather.model.WeatherOWMConvertedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class WeatherMocks {

  public static void setupMockBooksResponse(WireMockServer mockService) throws IOException {
    mockService.stubFor(
        WireMock.get(WireMock.urlEqualTo("/books"))
            .willReturn(
                WireMock.aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .withBody(
                        copyToString(
                            WeatherOWMConvertedResponse.class
                                .getClassLoader()
                                .getResourceAsStream("payload/get-books-response.json"),
                            defaultCharset()))));
  }
}
