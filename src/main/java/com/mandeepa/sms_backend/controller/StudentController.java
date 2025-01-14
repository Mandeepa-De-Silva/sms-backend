package com.mandeepa.sms_backend.controller;

import com.mandeepa.sms_backend.dto.StudentCreationRequest;
import com.mandeepa.sms_backend.dto.StudentDTO;
import com.mandeepa.sms_backend.dto.StudentUpdateRequest;
import com.mandeepa.sms_backend.exception.GlobalExceptionHandler;
import com.mandeepa.sms_backend.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin
@AllArgsConstructor
public class StudentController extends GlobalExceptionHandler {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Get Students", security = @SecurityRequirement(name = "Authorization"),
            responses = { @ApiResponse(content = @Content(schema = @Schema(implementation = StudentDTO.class))) })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Resource found"),
            @ApiResponse(responseCode = "400", description = "Invalid API argument") })
    @GetMapping(value = "/getStudents", produces = "application/json")
    public ResponseEntity<List<StudentDTO>> getStudent(){
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return ResponseEntity.ok(studentDTOList);
    }

    @Operation(summary = "Get Students", security = @SecurityRequirement(name = "Authorization"),
            responses = { @ApiResponse(content = @Content(schema = @Schema(implementation = StudentDTO.class))) })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Resource found"),
            @ApiResponse(responseCode = "400", description = "Invalid API argument") })
    @GetMapping(value = "/getStudent/{studentId}", produces = "application/json")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Long studentId){
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDTO);
    }

    @Operation(summary = "Create Student", security = @SecurityRequirement(name = " Authorization"),
            responses = { @ApiResponse(content = @Content(schema = @Schema(implementation = String.class))) })
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Resource created"),
            @ApiResponse(responseCode = "400", description = "Invalid API argument") })
    @PostMapping(value = "/createStudent", produces = "application/json")
    public String createStudent(@RequestBody @Valid StudentCreationRequest studentCreationRequest){
        return studentService.createStudent(studentCreationRequest);
    }

    @Operation(summary = "Update Student", security = @SecurityRequirement(name = " Authorization"))
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Resource updated"),
            @ApiResponse(responseCode = "400", description = "Invalid API argument") })
    @PutMapping(value="/updateStudent/{studentId}", produces = "application/json")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody StudentUpdateRequest studentUpdateRequest){
        studentService.updateStudent(studentId, studentUpdateRequest);
    }

    @Operation(summary = "Delete Student", security = @SecurityRequirement(name = " Authorization"),
            responses = { @ApiResponse(content = @Content(schema = @Schema(implementation = StudentDTO.class))) })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Resource deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid API argument") })
    @DeleteMapping(value = "/deleteStudent/{studentId}", produces = "application/json")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with the ID:" + studentId + " Deleted Successfully!");
    }


}
