package com.curd.Student.Student.Service;

import com.curd.Student.Student.Model.Student;
import com.curd.Student.Student.repo.StudentRepo;
import org.hibernate.dialect.function.AvgFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }
    public Student getStudentById(Integer id){
        return studentRepo.findById(id).orElse(null);
    }
    public Student createStudent(Student student){
        return studentRepo.save(student);
    }
    public boolean deleteStudentById(Integer id){
       if(studentRepo.existsById(id)){
           studentRepo.deleteById(id);
           return true;
       }else{
           return false;
       }
    }
    public Student updateStudentById(Integer id, Student student){
        if(studentRepo.existsById(id)){
            studentRepo.save(student);
            return student;
        }else{
            return null;
        }
    }
    public Student getStudentByName(String name){
        Student student = null;
        if(!name.equals("")){
            student = studentRepo.getStudentByName(name);
        }
        if(student != null){
            return student;
        }else{
            return null;
        }
    }
}
