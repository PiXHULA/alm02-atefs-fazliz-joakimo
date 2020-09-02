package com.alm2atefsfazlizjoakimo.fortuneteller.repository;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
