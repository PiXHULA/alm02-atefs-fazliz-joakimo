package com.alm2atefsfazlizjoakimo.fortuneteller.controller;


import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping(path = "/all")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @PostMapping
    public ResponseEntity<?> getFortune(@RequestBody  Person person) {
        Fortune fortune = Fortune.builder().fortune("YOU ARE GOING TO DIE SOON").build();
        return ResponseEntity.ok(fortune);
    }
}
