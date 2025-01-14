package com.mandeepa.sms_backend.service.impl;

import com.mandeepa.sms_backend.dto.StudentCreationRequest;
import com.mandeepa.sms_backend.dto.StudentDTO;
import com.mandeepa.sms_backend.dto.StudentUpdateRequest;
import com.mandeepa.sms_backend.entity.StudentEntity;
import com.mandeepa.sms_backend.exception.ResourceNotFoundException;
import com.mandeepa.sms_backend.mapper.StudentMapper;
import com.mandeepa.sms_backend.repository.StudentRepository;
import com.mandeepa.sms_backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOList = studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
        return studentDTOList;
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
    }

    @Override
    public String createStudent(StudentCreationRequest studentCreationRequest) {
        studentRepository.save(modelMapper.map(studentCreationRequest, StudentEntity.class));
        return studentCreationRequest.getFirstName() + " added successfully to the system";
    }

    @Override
    public void updateStudent(Long studentId, StudentUpdateRequest studentUpdateRequest) {
        StudentEntity oldStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        StudentEntity updatedStudentEntity = studentMapper.toUpdateStudent(studentUpdateRequest,oldStudent);
        studentRepository.save(updatedStudentEntity);
    }

    @Override
    public void deleteStudent(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        studentRepository.delete(studentEntity);
    }


}
