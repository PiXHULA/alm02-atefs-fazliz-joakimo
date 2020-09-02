package com.alm2atefsfazlizjoakimo.fortuneteller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ActiveProfiles("testuser")
public class SpringBootTest {

    @Test
    public void runSpringBootTest(){
        SpringApplication springApplication = mock(SpringApplication.class);
        springApplication.run();
        verify(springApplication, times(1)).run();
    }
}
