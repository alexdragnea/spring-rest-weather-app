package net.dg.springrestweather.client.errordecoder;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import feign.FeignException;
import feign.Request;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FeignErrorDecoderTest {

  @Mock private ErrorDecoder errorDecoder = new ErrorDecoder.Default();
  @InjectMocks private FeignErrorDecoder feignErrorDecoder;

  @Test
  void testThrowsRetryableExceptionForServiceUnavailable() {

    Response response =
        Response.builder()
            .status(503)
            .reason(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase())
            .request(
                Request.create(
                    Request.HttpMethod.GET,
                    StringUtils.EMPTY,
                    Collections.emptyMap(),
                    new byte[0],
                    null,
                    null))
            .body(StringUtils.EMPTY, UTF_8)
            .build();

    FeignException feignException = (FeignException) feignErrorDecoder.decode(null, response);

    Assertions.assertThat(feignException).isInstanceOf(RetryableException.class);
  }

  @Test
  void testThrowsRetryableExceptionForRequestTimeout() {

    Response response =
        Response.builder()
            .status(408)
            .reason(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase())
            .request(
                Request.create(
                    Request.HttpMethod.GET,
                    StringUtils.EMPTY,
                    Collections.emptyMap(),
                    new byte[0],
                    null,
                    null))
            .body(StringUtils.EMPTY, UTF_8)
            .build();

    FeignException feignException = (FeignException) feignErrorDecoder.decode(null, response);

    Assertions.assertThat(feignException).isInstanceOf(RetryableException.class);
  }

  @Test
  void testErrorDecoderDoesNotThrowException() {

    Response response =
        Response.builder()
            .status(200)
            .reason(HttpStatus.OK.getReasonPhrase())
            .request(
                Request.create(
                    Request.HttpMethod.GET,
                    StringUtils.EMPTY,
                    Collections.emptyMap(),
                    new byte[0],
                    null,
                    null))
            .body(StringUtils.EMPTY, UTF_8)
            .build();

    assertDoesNotThrow(() -> feignErrorDecoder.decode(null, response));
  }
}
