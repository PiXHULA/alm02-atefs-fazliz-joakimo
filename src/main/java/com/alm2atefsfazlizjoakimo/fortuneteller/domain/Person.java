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

    @NotBlank(message = "Name should not be blank")
    String name;
    @NotBlank(message = "Nationality should not be blank")
    String nationality;
    @NotBlank(message = "Ethnicity should not be blank")
    String Ethnicity;
    @NotBlank(message = "Birthday should not be blank")
    String Birthday;
    @NotBlank(message = "Gender should not be blank")
    String Gender;
}
