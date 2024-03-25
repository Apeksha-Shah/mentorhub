package com.apeksha.springboot_first.project1.Controller;

import com.apeksha.springboot_first.project1.Entity.Student;
import com.apeksha.springboot_first.project1.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student save(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> findstudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{sr_no}")
    public Student findbyid(@PathVariable int sr_no){
        return studentService.findById(sr_no);
    }

    @PutMapping("/students")
    public Student update(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/students/{sr_no}")
    public String remove(@PathVariable int sr_no){
        return studentService.deleteById(sr_no);
    }

    @PutMapping("/association/student/{s_id}/mentor/{m_id}")
    public Student association(@PathVariable int s_id, @PathVariable int m_id){
        return studentService.associate(s_id,m_id);
    }

    @DeleteMapping("/deleteAssociation/student/{s_id}/mentor/{m_id}")
    public Student deleteAssociation(@PathVariable int s_id, @PathVariable int m_id){
        return studentService.deleteAssociation(s_id,m_id);
    }


}
