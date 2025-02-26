package com.jpahibernate.example.student_management.controller;

import com.jpahibernate.example.student_management.model.Student;
import com.jpahibernate.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id)
    {
        Student student = studentService.findStudentById(id);
        return student;
    }
   @GetMapping("/findAll")
    public List<Student> findAllStudents()
    {
        List<Student> studentList = studentService.findAllStudents();
        return studentList;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id)
    {
        String response = studentService.deleteStudentById(id);
        return response;
    }
    @PutMapping("/updatePut/{id}")
    public String updateStudentByPut(@PathVariable int id,@RequestBody Student studentRequest)
    {
        String response = studentService.updateStudentByPut(id,studentRequest);
        return response;
    }
    @PatchMapping("/updatePatch/{id}")
    public String updateStudentMobileByPatch(@PathVariable int id,@RequestParam String mobile)
    {
        String response = studentService.updateStudentMobileByPatch(id,mobile);
        return response;
    }
}
