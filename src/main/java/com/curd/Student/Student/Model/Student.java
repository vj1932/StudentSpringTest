package com.curd.Student.Student.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.curd.Student.Student.Model.Department;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
    private String roleNo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department Department;

}
