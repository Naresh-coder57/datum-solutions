package com.datumsolutions.repository;

import com.datumsolutions.model.Student;


public interface StudentDao {

    Student saveStudent(Student student);
    Student getStudent(String student);
    Student updateStudent(Student student);  
    String deleteStudent(String string);   

}
