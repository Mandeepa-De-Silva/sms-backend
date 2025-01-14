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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_id", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "dob", nullable = false)
    private String dob;
}
