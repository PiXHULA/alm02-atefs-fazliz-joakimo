package com.alm2atefsfazlizjoakimo.fortuneteller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.MongoDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testuser")
@DataMongoTest
public class PersonTest {
    MongoDb mongoDb;

    @Autowired
    public PersonTest(MongoDb mongoDb) {
        this.mongoDb = mongoDb;
    }

    @Test
    public void addingPersonToMongoDBAndGettingPersonFromMongo(){
        Person jocke = Person.builder().name("Joakim").build();
        Person atef = new Person();
        atef = mongoDb.save(jocke);
        assertThat(jocke.getName()).isEqualTo(atef.getName());
    }


}
