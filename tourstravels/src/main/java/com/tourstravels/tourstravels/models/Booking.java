package com.tourstravels.tourstravels.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  flight;


    private String tour;


    private String  hotel;

    private boolean insurance;
    private Long date;

    private String user;

    private String status;
}
