package com.example.demo.Controllers;

import com.example.demo.Models.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudentList(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") long id){
        studentService.removeStudent(id);
    }
    @PutMapping(path = "{studentID}")
    public void changeStudentInfo(@PathVariable("studentID") long id,@RequestBody Student student){
        studentService.changeStudentData(id,student);
    }

}
