package com.alm2atefsfazlizjoakimo.fortuneteller.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class Fortune {
    @Id
    String ID;
    String fortune;
    String country;
}
