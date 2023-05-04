package com.tourstravels.tourstravels.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int fare;
    private String fName;
    private String fromCity;
    private String toCity;
    private String fromState;
    private String fromCountry;
    private String toState;
    private String toCountry;

}
