package com.mandeepa.sms_backend.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class StudentCreationRequest {

    private String firstName;
    private String lastName;
    @Email(message = "Email is mandatory")
    private String email;
    private String phone;
    private String address;
    private String city;
    private String dob;
}
