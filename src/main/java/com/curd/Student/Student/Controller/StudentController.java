package com.curd.Student.Student.Controller;

import com.curd.Student.Student.Model.Student;
import com.curd.Student.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/getStudents")
    public List<Student> findAll(){
        return studentService.getStudent();
    }
    @GetMapping("/getStudent/{id}")
    public Student findById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public boolean deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudentById(id,student);
    }
    @GetMapping("/")
    public String getHelloWorld(){
        return "Hello World!";
    }

}
