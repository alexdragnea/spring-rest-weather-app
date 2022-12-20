package net.dg.springrestweather.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.ValidationException;
import net.dg.springrestweather.client.thingspeak.ThingSpeakClient;
import net.dg.springrestweather.constants.TestConstants;
import net.dg.springrestweather.service.converter.ThingSpeakResponseConverterService;
import net.dg.springrestweather.service.impl.ThingSpeakServiceImpl;
import net.dg.springrestweather.service.validation.ThingSpeakValidationService;
import net.dg.springrestweather.utility.ThingSpeakConvertedResponseObjectMother;
import net.dg.springrestweather.utility.ThingSpeakObjectMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ThingSpeakController.class)
class ThingSpeakControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean private ThingSpeakClient thingSpeakClient;
  @MockBean private ThingSpeakServiceImpl thingSpeakService;
  @MockBean private ThingSpeakResponseConverterService thingSpeakResponseConverterService;
  @MockBean private ThingSpeakValidationService thingSpeakValidationService;

  @Test
  void testGetThingSpeakData() throws Exception {

    when(thingSpeakService.getData()).thenReturn(ThingSpeakObjectMother.buildThingSpeakResponse());

    when(thingSpeakResponseConverterService.convertThingSpeakResponse(any()))
        .thenReturn(ThingSpeakConvertedResponseObjectMother.buildConvertedResponse());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(TestConstants.GET_THING_SPEAK_DATA)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.temperature").isNotEmpty())
        .andExpect(jsonPath("$.temperature").value(TestConstants.TEST))
        .andExpect(jsonPath("$.pressure").isNotEmpty())
        .andExpect(jsonPath("$.pressure").value(TestConstants.TEST))
        .andExpect(jsonPath("$.humidity").isNotEmpty())
        .andExpect(jsonPath("$.humidity").value(TestConstants.TEST))
        .andExpect(jsonPath("$.created_at").isNotEmpty());
  }

  @Test
  void testGetThingSpeakDataWillCatchException() throws Exception {

    when(thingSpeakService.getData()).thenReturn(ThingSpeakObjectMother.buildThingSpeakResponse());

    when(thingSpeakResponseConverterService.convertThingSpeakResponse(any()))
        .thenReturn(ThingSpeakConvertedResponseObjectMother.buildConvertedResponse());

    doThrow(ValidationException.class).when(thingSpeakValidationService).validate(any());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get(TestConstants.GET_THING_SPEAK_DATA)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isInternalServerError());
  }
}
