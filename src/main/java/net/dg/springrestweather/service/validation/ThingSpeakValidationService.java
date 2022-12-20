package net.dg.springrestweather.service.validation;

import java.util.Objects;
import javax.validation.ValidationException;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ThingSpeakValidationService {

  private static final String VALIDATION_FORMAT = "Constraint validation: %s.";

  public void validate(ThingSpeakResponse thingSpeakResponse) throws ValidationException {

    if (Objects.isNull(thingSpeakResponse)) {
      throw new ValidationException(
          String.format(VALIDATION_FORMAT, "thingSpeakResponse cannot be null or empty"));
    }
    if (Objects.isNull(thingSpeakResponse.getChannel().getField1())
        || StringUtils.isEmpty(thingSpeakResponse.getChannel().getField1())) {
      throw new ValidationException(
          String.format(
              VALIDATION_FORMAT, "thingSpeakResponse.channel.field1 cannot be null or empty"));
    }
    if (Objects.isNull(thingSpeakResponse.getChannel().getField2())
        || StringUtils.isEmpty(thingSpeakResponse.getChannel().getField2())) {
      throw new ValidationException(
          String.format(
              VALIDATION_FORMAT, "thingSpeakResponse.channel.field2 cannot be null or empty"));
    }
    if (Objects.isNull(thingSpeakResponse.getChannel().getField3())
        || StringUtils.isEmpty(thingSpeakResponse.getChannel().getField3())) {
      throw new ValidationException(
          String.format(
              VALIDATION_FORMAT, "thingSpeakResponse.channel.field3 cannot be null or empty"));
    }
    if (Objects.isNull(thingSpeakResponse.getFeeds().get(0).getCreatedAt())
        || StringUtils.isEmpty(
            String.valueOf(thingSpeakResponse.getFeeds().get(0).getCreatedAt()))) {
      throw new ValidationException(
          String.format(
              VALIDATION_FORMAT, "thingSpeakResponse.feeds.createdAt cannot be null or empty"));
    }
  }
}
