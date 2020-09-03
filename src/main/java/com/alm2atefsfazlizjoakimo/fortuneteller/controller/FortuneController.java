package com.alm2atefsfazlizjoakimo.fortuneteller.controller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.service.FortuneService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/person")
@RequiredArgsConstructor
public class FortuneController {

   private final FortuneService fortuneService;

    @PostMapping
    public ResponseEntity<?> getFortune(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(fortuneService.getFortune(person));
    }


}
