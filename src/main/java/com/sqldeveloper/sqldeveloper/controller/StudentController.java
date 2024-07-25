package com.sqldeveloper.sqldeveloper.controller;

import com.sqldeveloper.sqldeveloper.entitiy.Student;
import com.sqldeveloper.sqldeveloper.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            // Öğrenci ekle
            String result = studentService.addStudent(student);
            return ResponseEntity.ok(result); // Başarılı ekleme sonrası yanıt
        } catch (Exception e) {
            // Hata yönetimi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding student: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        try {
            // Öğrenci güncelle
            String result = studentService.updateStudent(student);
            return ResponseEntity.ok(result); // Başarılı güncelleme sonrası yanıt
        } catch (Exception e) {
            // Hata yönetimi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student: " + e.getMessage());
        }
    }
}
