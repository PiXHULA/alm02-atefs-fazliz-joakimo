package com.alm2atefsfazlizjoakimo.fortuneteller.IT.repository;


import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.FortuneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testuser")
@DataMongoTest
public class FortuneRepositoryTest {

    @Autowired
    FortuneRepository fortuneRepository;
    Fortune fortuneTest;

    @BeforeEach
    void beforeEach() {
        Fortune fortune = new Fortune();
        fortune.setFortune("You will be rich some day");
        fortune.setID("asd");
        fortune.setCountry("sweden");
        fortuneTest = fortuneRepository.save(fortune);
    }

    @Test
    public void receiveFortuneFromDbTest() { //correct name?
        Fortune fortune = fortuneRepository.findById(fortuneTest.getID()).orElse(null);
        assert fortune != null;
        assertThat(fortune.getFortune()).isEqualTo(fortuneTest.getFortune());
        assertThat(fortune.getCountry()).isEqualTo(fortuneTest.getCountry());
        assertThat(fortune.getID()).isEqualTo(fortuneTest.getID());
    }
}
