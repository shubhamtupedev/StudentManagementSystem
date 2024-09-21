package com.springframework.studentmanagementsystem.controller;

import com.springframework.studentmanagementsystem.entity.Student;
import com.springframework.studentmanagementsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{sId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long sId) {
        return ResponseEntity.ok(studentService.getStudentById(sId));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{sId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long sId) {
        return ResponseEntity.ok(studentService.updateStudent(sId, student));
    }

    @DeleteMapping("/{sId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long sId) {
        studentService.deleteStudent(sId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
