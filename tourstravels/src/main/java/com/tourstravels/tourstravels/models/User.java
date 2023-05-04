package com.tourstravels.tourstravels.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String  email;
    private String password;
    private String gender;
    private String address;
    private String phoneNumber;
    private String role;

    public User(String name, String email, String password, String gender, String address, String phoneNumber,String role,Long date) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role=role;

    }
}
