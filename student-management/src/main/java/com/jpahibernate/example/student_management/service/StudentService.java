package com.jpahibernate.example.student_management.service;

import com.jpahibernate.example.student_management.model.Student;
import com.jpahibernate.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student)
    {
        studentRepository.save(student);
        return "Student saved successfully";
    }
     public Student findStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.get();
     }
     public List<Student> findAllStudents()
     {
         List<Student> studentList = studentRepository.findAll();
         return studentList;
     }

     public String deleteStudentById(int id)
     {
         studentRepository.deleteById(id);
         return "Student with id : " +id+ "is deleted successfully";
     }

     public String updateStudentByPut(int studentId,Student studentRequest)
     {
         Student studentFromDb = findStudentById(studentId);
         if(studentFromDb!=null)
         {
             studentRepository.save(studentRequest);
             return "Student update successfully";
         }
         else
         {
             return "Cannot find student to update";
         }
     }

     public String updateStudentMobileByPatch(int studentId,String mobile)
     {
         Student studentFromDb = findStudentById(studentId);
         if(studentFromDb!=null)
         {
             studentFromDb.setMobile(mobile);
             studentRepository.save(studentFromDb);
             return "Student mobile number updated successfully";
         }
         else
         {
             return "Cannot find student to update";
         }
     }
}
