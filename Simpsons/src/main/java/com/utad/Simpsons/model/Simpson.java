package com.utad.Simpsons.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Simpson_table")

public class Simpson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String personality;

}
