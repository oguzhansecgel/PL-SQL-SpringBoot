package com.sqldeveloper.sqldeveloper.entitiy;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@ToString
public class Student {
    @Id
    @Column(name = "student_id")
    private Long id;
    private String name;
}
