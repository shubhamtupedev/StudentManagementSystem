package com.springframework.studentmanagementsystem.service.impl;

import com.springframework.studentmanagementsystem.entity.Student;
import com.springframework.studentmanagementsystem.repository.StudentRepository;
import com.springframework.studentmanagementsystem.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Fetching all students from the database.");
        logger.error("Fetching all students from the database.");
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long sId) {
        logger.info("getStudentById {}", sId);
        return studentRepository.findById(sId).orElseThrow(() -> new RuntimeException("Student details not found"));
    }

    @Override
    public Student saveStudent(Student student) {
        logger.info("Saving new student to the database: {}", student);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long sId, Student student) {
        logger.info("Updating student with ID: {}", sId);
        Student existingStudent = getStudentById(sId);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long sId) {
        logger.info("Updating student with ID2: {}", sId);
        studentRepository.deleteById(sId);
    }
}
