package com.tourstravels.tourstravels.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;
    private String pkgName;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photo;
    private int price;
    private String city;
    private String state;
    private String country;
}
