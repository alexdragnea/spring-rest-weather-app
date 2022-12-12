package net.dg.springrestweather.exceptions;

import feign.RetryableException;
import javax.validation.ValidationException;
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
  public ResponseEntity<String> retryExceptionHandler(RetryableException e) {

    LOGGER.info("Couldn't establish connection to the OWM Api.");

    return new ResponseEntity<>(
        "Service unavailable at the moment, please try again later.",
        HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler({ValidationException.class})
  public ResponseEntity<String> validationExceptionHandler(Exception e) {

    LOGGER.info("Validation Exception occurred: {}", e.getMessage());

    return new ResponseEntity<>("Validation Exception occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
