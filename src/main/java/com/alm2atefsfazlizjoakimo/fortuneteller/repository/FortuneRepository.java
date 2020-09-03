package com.alm2atefsfazlizjoakimo.fortuneteller.repository;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FortuneRepository extends MongoRepository<Fortune, String> {
    List<Fortune> findDistinctByCountryIgnoreCase(String country);
}
