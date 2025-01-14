package com.mandeepa.sms_backend.repository;

import com.mandeepa.sms_backend.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {// JpaRepository is used to perform CRUD operations

    Optional<StudentEntity> findById(Long studentId);
}
