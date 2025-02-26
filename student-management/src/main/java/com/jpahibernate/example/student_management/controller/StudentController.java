package com.jpahibernate.example.student_management.controller;

import com.jpahibernate.example.student_management.model.Student;
import com.jpahibernate.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/apis")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public String  saveStudent(@RequestBody Student student){
        String response =  studentService.addStudent(student);
        return response;
    }
}
