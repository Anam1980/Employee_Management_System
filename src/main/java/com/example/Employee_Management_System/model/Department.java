package com.example.Employee_Management_System.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "department")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
//    departmentId: String (Primary Key)
//● departmentName: String
//● createdAt: Timestamp
//● updatedAt: Timestamp


    String departmentId;

    String departmentName;

    Timestamp createdAt;

    Timestamp updatedAt;




}
