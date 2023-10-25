package com.project.spendWise.entity;



import jakarta.persistence.*;
import lombok.Data;
//import org.springframework.data.annotation.Id;

import java.util.Collection;


@Entity
@Data
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        private Long id;
    @Column(name = "username")
        private String username;
    @Column(name = "total_salary")
        private double totalSalary;




    // getters and setters
    }

