package com.example.Employee_Management_System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="employee")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
//    id: Long (Primary Key)
//● firstName: String
//● lastName: String
//● email: String
//● departmentId: String (Foreign Key)
//● createdAt: Timestamp
//● updatedAt: Timestamp

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;

    String lastName;

    @Column(unique = true)
    @Email
    String email;

    String departmentId;

   Timestamp createdAt;

   Timestamp updatedAt;



}
