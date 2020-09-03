package com.alm2atefsfazlizjoakimo.fortuneteller.repository;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FortuneRepository extends MongoRepository<Fortune, String> {
    Optional<Fortune> findFortuneByCountryIgnoreCase(String country);
}
