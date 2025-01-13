package com.mandeepa.sms_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates getters and setters
@NoArgsConstructor // generates no argument constructor
@AllArgsConstructor // generates all argument constructor
@Entity(name = "student") // specifies that the class is an entity and is mapped to a database table
public class StudentEntity {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "dob")
    private String dob;
}
