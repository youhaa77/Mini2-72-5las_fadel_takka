package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String licenseNumber;

    private Double avgRatingScore;

    @JsonIgnore
    @OneToMany(mappedBy = "captain")
    private List<Trip> trips;

    public Captain() {}

    public Captain(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public Captain(Long id, String name, String licenseNumber, Double avgRatingScore) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    // Getters and Setters...
}
