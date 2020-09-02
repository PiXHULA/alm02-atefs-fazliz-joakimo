package com.alm2atefsfazlizjoakimo.fortuneteller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testuser")
@DataMongoTest
public class PersonTest {
    PersonRepository personRepository;

    @Autowired
    public PersonTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    public void addingPersonToMongoDBAndGettingPersonFromMongo(){
        Person jocke = Person.builder().name("Joakim").build();
        Person fazli = new Person();
        fazli.setID("12345");
        fazli.setName("Fazli");
        fazli.setBirthday("Never");
        fazli.setGender("Unknown");
        fazli.setNationality("Immigrant");
        fazli.setEthnicity("Kind person");
        Person atef = new Person();
        atef = personRepository.save(jocke);
        assertThat(jocke.getName()).isEqualTo(atef.getName());
        jocke.setName("Jocke");
        assertThat(jocke.getName()).isEqualTo(atef.getName());

        assertThat(fazli.getID()).isEqualTo("12345");
        assertThat(fazli.getName()).isEqualTo("Fazli");
        assertThat(fazli.getBirthday()).isEqualTo("Never");
        assertThat(fazli.getGender()).isEqualTo("Unknown");
        assertThat(fazli.getNationality()).isEqualTo("Immigrant");
        assertThat(fazli.getEthnicity()).isEqualTo("Kind person");
    }


}
