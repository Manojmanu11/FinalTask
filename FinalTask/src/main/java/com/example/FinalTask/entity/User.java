package com.example.FinalTask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private int phoneNo;
    private String email;

    public User( String name, int age, int phoneNo, String email) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.email = email;
    }
}