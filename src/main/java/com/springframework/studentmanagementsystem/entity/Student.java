package com.springframework.studentmanagementsystem.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    public Student() {
    }

    public Student(int age, String email, String firstName, String lastName, Long sId) {
        this.age = age;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sId = sId;
    }

    public Student(int age, String email, String firstName, String lastName) {
        this.age = age;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", sId=" + sId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
