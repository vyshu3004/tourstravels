package com.tourstravels.tourstravels.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pname;
    private String description;
    private String city;
    private String state;
    private String country;
    @Lob
    @Column(columnDefinition = "longtext")
    private String photo;

}
