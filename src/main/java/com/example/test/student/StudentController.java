package com.example.test.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    public Collection<Student> getStudents(){
        return studentService.getList();
    }

    @PostMapping
    public void store(@RequestBody Student student){
        studentService.create(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void destroy(@PathVariable("studentId") Long id){
        studentService.delete(id);
    }

    @PutMapping(path = "{studentId}")
    public void update(
            @PathVariable("studentId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate dob
    ){
        studentService.update(id,name,email,dob);
    }
}
