package com.alm2atefsfazlizjoakimo.fortuneteller.repository;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDb extends MongoRepository<Person, String> {

}
