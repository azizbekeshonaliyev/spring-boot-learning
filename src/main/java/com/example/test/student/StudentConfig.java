package com.example.test.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
          Student azizbek = new Student(
                  "Azizbek",
                  "azizbek@gmail.com",
                  LocalDate.of(1996, Month.MARCH,29)
              );
          Student abdusamad = new Student(
                  "Abdusamad",
                  "abdusamad@gmail.com",
                  LocalDate.of(1996, Month.NOVEMBER,5)
              );

          repository.saveAll(
                  Arrays.asList(azizbek,abdusamad)
          );
        };
    }
}
