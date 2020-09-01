package com.alm2atefsfazlizjoakimo.fortuneteller.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    String ID;
    String name;
    String nationality;
    String Ethnicity;
    String Birthday;
    String Gender;
}
