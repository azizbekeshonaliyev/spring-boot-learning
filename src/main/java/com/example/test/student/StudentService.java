package com.example.test.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getList(){
        return studentRepository.findAll();
    }

    public Student create(Student student) {
           Optional<Student> student1 = studentRepository.findStudentByEmail(student.getEmail());

           if (student1.isPresent()){
               throw new IllegalStateException("This email already taken");
           }

           return studentRepository.save(student);
    }

    public void delete(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("this id " + id + " student does not exists!");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email, LocalDate dob) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException("this id " + id + " student does not exists!"));
        if (
                name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(),name)
        ){
            student.setName(name);
        }

        if (
                email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(),email)
        ) {
                Optional<Student> student1 = studentRepository.findStudentByEmail(email);
                if (student1.isPresent()){
                    throw new IllegalStateException("This email already taken");
                }
                student.setEmail(email);
        }

        if (
                dob != null &&
                !Objects.equals(student.getDob(),dob)
        ){
            student.setDob(dob);
        }

//        studentRepository.save(student);
    }
}
