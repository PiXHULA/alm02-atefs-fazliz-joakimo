package com.alm2atefsfazlizjoakimo.fortuneteller.UnitTest.service;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.FortuneRepository;
import com.alm2atefsfazlizjoakimo.fortuneteller.service.FortuneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ActiveProfiles("testuser")
@ExtendWith(MockitoExtension.class)
public class FortuneServiceTest {

    ArrayList <Fortune> fortuneList = new ArrayList<>();
    Person mockPerson;

    @Captor
    ArgumentCaptor<String> nationalityCaptor;

    @Mock
    FortuneRepository fortuneRepository;

    @InjectMocks
    FortuneService fortuneService;

    @BeforeEach
    void beforeEach() {
        mockPerson = Person.builder()
                .nationality("Sweden")
                .build();
        Fortune mockFortune = Fortune.builder()
                .fortune("Wow you are amazing")
                .country("Sweden")
                .build();
        fortuneList.add(mockFortune);
        mockFortune = Fortune.builder()
                .fortune("Wow you are not amazing")
                .country("Usa")
                .build();
        fortuneList.add(mockFortune);
    }

    @Test
    public void getFortuneTest() {
        given(fortuneRepository.findDistinctByCountryIgnoreCase(any(String.class))).willReturn(fortuneList);
        Fortune fortune = fortuneService.getFortune(mockPerson);

        assertThat(fortune).isNotNull();
        then(fortuneRepository)
                .should(times(1))
                .findDistinctByCountryIgnoreCase(nationalityCaptor.capture());
        assertThat(nationalityCaptor.getValue()).isEqualTo("Sweden");
        assertThat(fortune.getCountry()).isEqualTo(mockPerson.getNationality());
    }

    @Test
    public void getDefaultFortuneTest(){
        given(fortuneRepository.findDistinctByCountryIgnoreCase(any(String.class))).willReturn(new ArrayList<>());
        Fortune fortune = fortuneService.getFortune(Person.builder().nationality("Not Use").build());
        assertThat(fortune.getCountry()).isNull();
        assertThat(fortune.getFortune()).isEqualTo("YOU ARE GOING TO DIE SOON");
        then(fortuneRepository)
                .should(times(1))
                .findDistinctByCountryIgnoreCase(nationalityCaptor.capture());
        assertThat(nationalityCaptor.getValue()).isEqualTo("Not Use");
    }
}
