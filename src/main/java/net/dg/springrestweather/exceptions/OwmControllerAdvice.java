package net.dg.springrestweather.exceptions;

import feign.RetryableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class OwmControllerAdvice extends ResponseEntityExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(OwmControllerAdvice.class);

  @ExceptionHandler({RetryableException.class})
  public ResponseEntity<String> retryException(RetryableException e) {

    LOGGER.info("Handling RetryableException: {}", e.getMessage());
    return new ResponseEntity<>(
        "Service unavailable at the moment, please try again later.",
        HttpStatus.SERVICE_UNAVAILABLE);
  }
}
