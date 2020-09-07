package com.alm2atefsfazlizjoakimo.fortuneteller.IT.controller;

import com.alm2atefsfazlizjoakimo.fortuneteller.controller.FortuneController;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.service.FortuneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FortuneController.class)
@ActiveProfiles("testuser")
public class FortuneControllerTest {

    Fortune fortuneTest;

    @MockBean
    FortuneService fortuneService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        fortuneTest = Fortune.builder()
                .fortune("You will be rich some day")
                .country("sweden")
                .build();
        given(fortuneService.getFortune(any(Person.class))).willReturn(fortuneTest);
    }

    @Test
    public void itShouldReturnFortune() throws Exception {
        String mockPerson = new ObjectMapper().writeValueAsString(
                Person.builder()
                .name("Joakim")
                .Birthday("April 29")
                .Ethnicity("Swedish Chilean")
                .nationality("Sweden")
                .Gender("Male")
                .build());

        mockMvc.perform(post("/fortune").contentType(MediaType.APPLICATION_JSON).content(mockPerson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fortune", is(fortuneTest.getFortune())))
                .andExpect(jsonPath("$.country", is(fortuneTest.getCountry())))
                .andDo(print());
    }

    @Test
    public void itShouldNotReturnFortune() throws Exception {
        String mockPerson = new ObjectMapper().writeValueAsString(
                Person.builder()
                        .build());

        mockMvc.perform(post("/fortune").contentType(MediaType.APPLICATION_JSON).content(mockPerson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors", hasSize(5)))
                .andDo(print());
    }
}
