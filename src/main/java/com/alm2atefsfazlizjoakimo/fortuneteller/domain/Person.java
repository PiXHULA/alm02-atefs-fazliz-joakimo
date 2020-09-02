package com.alm2atefsfazlizjoakimo.fortuneteller.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class Person {
    @Id
    String ID;

    @NotBlank
    String name;
    @NotBlank
    String nationality;
    @NotBlank
    String Ethnicity;
    @NotBlank
    String Birthday;
    @NotBlank
    String Gender;
}
