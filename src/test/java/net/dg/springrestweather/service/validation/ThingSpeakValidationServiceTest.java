package net.dg.springrestweather.service.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import javax.validation.ValidationException;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.model.thingspeak.Channel;
import net.dg.springrestweather.model.thingspeak.Feed;
import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import net.dg.springrestweather.utility.ThingSpeakObjectMother;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ThingSpeakValidationServiceTest {

  @InjectMocks private ThingSpeakValidationService thingSpeakValidationService;

  @Test
  void testInvalidObject() {

    ThingSpeakResponse thingSpeakResponse = null;

    Throwable ex =
        assertThrows(
            ValidationException.class,
            () -> thingSpeakValidationService.validate(thingSpeakResponse));
    assertEquals(TestConstants.INVALID_THING_SPEAK_OBJECT, ex.getMessage());
  }

  @Test
  void testInvalidField1() {

    ThingSpeakResponse thingSpeakResponse = ThingSpeakObjectMother.buildThingSpeakResponse();

    Channel channel = ThingSpeakObjectMother.buildChannel();
    channel.setField1(StringUtils.EMPTY);

    thingSpeakResponse.setChannel(channel);
    Throwable ex =
        assertThrows(
            ValidationException.class,
            () -> thingSpeakValidationService.validate(thingSpeakResponse));
    assertEquals(TestConstants.INVALID_THING_SPEAK_FIELD_1, ex.getMessage());
  }

  @Test
  void testInvalidField2() {

    ThingSpeakResponse thingSpeakResponse = ThingSpeakObjectMother.buildThingSpeakResponse();

    Channel channel = ThingSpeakObjectMother.buildChannel();
    channel.setField2(StringUtils.EMPTY);

    thingSpeakResponse.setChannel(channel);
    Throwable ex =
        assertThrows(
            ValidationException.class,
            () -> thingSpeakValidationService.validate(thingSpeakResponse));
    assertEquals(TestConstants.INVALID_THING_SPEAK_FIELD_2, ex.getMessage());
  }

  @Test
  void testInvalidField3() {

    ThingSpeakResponse thingSpeakResponse = ThingSpeakObjectMother.buildThingSpeakResponse();

    Channel channel = ThingSpeakObjectMother.buildChannel();
    channel.setField3(StringUtils.EMPTY);

    thingSpeakResponse.setChannel(channel);
    Throwable ex =
        assertThrows(
            ValidationException.class,
            () -> thingSpeakValidationService.validate(thingSpeakResponse));
    assertEquals(TestConstants.INVALID_THING_SPEAK_FIELD_3, ex.getMessage());
  }

  @Test
  void testInvalidCreatedAt() {

    ThingSpeakResponse thingSpeakResponse = ThingSpeakObjectMother.buildThingSpeakResponse();

    Feed feed = ThingSpeakObjectMother.buildFeed();
    feed.setCreatedAt(null);

    thingSpeakResponse.setFeeds(List.of(feed));
    Throwable ex =
        assertThrows(
            ValidationException.class,
            () -> thingSpeakValidationService.validate(thingSpeakResponse));
    assertEquals(TestConstants.INVALID_THING_SPEAK_CREATED_AT, ex.getMessage());
  }

  @Test
  void testValidFields() {
    ThingSpeakResponse thingSpeakResponse = ThingSpeakObjectMother.buildThingSpeakResponse();

    assertDoesNotThrow(() -> thingSpeakValidationService.validate(thingSpeakResponse));
  }
}
