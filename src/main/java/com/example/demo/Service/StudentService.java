package com.example.demo.Service;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
                return studentRepository.findAll();
    }
    public void addNewStudent(Student student){
        studentRepository.save(student);
    }
    public void removeStudent(long id){
        if(studentRepository.existsById(id)) studentRepository.deleteById(id);
        else throw new IllegalStateException("The student Id "+ id + " is Invalid");
    }

    public void changeStudentData(long id, Student student){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            studentRepository.save(student);
        }else studentRepository.save(student);
    }

}
