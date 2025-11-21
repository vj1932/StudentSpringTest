package com.curd.Student.Student.repo;

import com.curd.Student.Student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student getStudentByName(String name);
}
