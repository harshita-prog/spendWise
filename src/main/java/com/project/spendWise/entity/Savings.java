package com.project.spendWise.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    @ManyToOne
    @JoinColumn
    private User user; // Many-to-One relationship with User
    // getters and setters
}