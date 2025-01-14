package com.mandeepa.sms_backend.service;

import com.mandeepa.sms_backend.dto.StudentCreationRequest;
import com.mandeepa.sms_backend.dto.StudentDTO;
import com.mandeepa.sms_backend.dto.StudentUpdateRequest;

import java.util.List;

public interface StudentService {

    //get all students
    List<StudentDTO> getAllStudents();

    //get a student by id
    StudentDTO getStudentById(Long studentId);

    //create a student
    String createStudent(StudentCreationRequest studentDTO);

    //update a student
    void updateStudent(Long studentId, StudentUpdateRequest studentDTO);

    //delete a student
    void deleteStudent(Long studentId);
}
