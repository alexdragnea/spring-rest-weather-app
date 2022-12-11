package net.dg.springrestweather.exceptions;

import feign.Request;
import feign.RetryableException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import javax.validation.ValidationException;
import net.dg.springrestweather.constants.TestConstants;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class OwmControllerAdviceTest {

  @InjectMocks OwmControllerAdvice owmControllerAdvice;

  @Test
  void testRetryableExceptionHandler() {

    ResponseEntity<String> responseEntity =
        owmControllerAdvice.retryExceptionHandler(
            new RetryableException(
                408,
                StringUtils.EMPTY,
                Request.HttpMethod.GET,
                new SocketTimeoutException(),
                null,
                Request.create(
                    Request.HttpMethod.GET,
                    StringUtils.EMPTY,
                    Collections.emptyMap(),
                    new byte[0],
                    null,
                    null)));
    Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responseEntity.getStatusCode());
    Assertions.assertEquals(
        TestConstants.RETRYABLE_RESPONSE_EXCEPTION_MESSAGE, responseEntity.getBody());
  }

  @Test
  void testGlobalExceptionHandler() {
    ResponseEntity<String> responseEntity =
        owmControllerAdvice.validationExceptionHandler(new ValidationException());
    Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
  }
}
