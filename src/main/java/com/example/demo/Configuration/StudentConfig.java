package com.example.demo.Configuration;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args->{
           Student aravind = new Student(1,"Aravind","araviimakesitcool@gmail.com",25, LocalDate.of(1996,9,24));
            Student davies = new Student(2,"Davies","daveisIsAmazing@gmail.com",226, LocalDate.of(1992,11,1));

            studentRepository.saveAll(Arrays.asList(aravind,davies));
        };
    }

}
