package com.springframework.studentmanagementsystem.service;

import com.springframework.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(Long sId);

    public Student saveStudent(Student student);

    public Student updateStudent(Long sId, Student student);

    public void deleteStudent(Long sId);
}
