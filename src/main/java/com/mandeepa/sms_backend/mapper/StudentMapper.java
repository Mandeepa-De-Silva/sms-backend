package com.mandeepa.sms_backend.mapper;

import com.mandeepa.sms_backend.dto.StudentUpdateRequest;
import com.mandeepa.sms_backend.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentEntity toUpdateStudent(StudentUpdateRequest studentUpdateRequest, StudentEntity oldStudent) {
        StudentEntity student = new StudentEntity();
        student.setId(oldStudent.getId());
        student.setFirstName(studentUpdateRequest.getFirstName());
        student.setLastName(studentUpdateRequest.getLastName());
        student.setEmail(studentUpdateRequest.getEmail());
        student.setPhone(studentUpdateRequest.getPhone());
        student.setAddress(studentUpdateRequest.getAddress());
        student.setCity(studentUpdateRequest.getCity());
        student.setDob(studentUpdateRequest.getDob());
        return student;
    }
}
