package com.curd.Student.Student.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")   // ✅ Explicitly define the column
    private Long profileId;

    @Column(name = "bio")
    private String bio;
}
