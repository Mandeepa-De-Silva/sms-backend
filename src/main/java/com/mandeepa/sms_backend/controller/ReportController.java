package com.mandeepa.sms_backend.controller;

import com.mandeepa.sms_backend.entity.StudentEntity;
import com.mandeepa.sms_backend.repository.StudentRepository;
import com.mandeepa.sms_backend.service.StudentService;
import com.mandeepa.sms_backend.util.JasperReportUtil;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReportController {

    private final StudentRepository studentRepository;

    @GetMapping("/report")
    public ResponseEntity<byte[]> generateReport() {
        try {
            // Fetch data from the database
            List<StudentEntity> data = studentRepository.findAll();

            // Path to the Jasper template file
            String templatePath = new File("C:\\Users\\user\\Desktop\\sms-backend\\sms-backend\\src\\main\\resources\\reports\\StudentRecords.jasper").getAbsolutePath();

            // Report parameters
            Map<String, Object> parameters = new HashMap<>();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
            parameters.put("TABLE_DATA_SOURCE", dataSource);

            // Generate the report
            byte[] pdfBytes = JasperReportUtil.generateReport(data, templatePath, parameters);

            // Set headers for the response
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
            headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (JRException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
