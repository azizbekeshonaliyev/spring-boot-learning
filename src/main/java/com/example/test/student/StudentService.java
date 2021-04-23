package com.example.test.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;

@Service
public class StudentService {
    public Collection<Student> getList(){
        return Collections.singletonList(new Student(1L, "Azizbek", "1996azizbekeshonaliyev@gmail.com", LocalDate.of(1996, Month.MARCH, 29)));
    }
}
