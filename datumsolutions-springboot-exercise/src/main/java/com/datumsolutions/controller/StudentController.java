package com.datumsolutions.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datumsolutions.model.Student;
import com.datumsolutions.repository.StudentDao;

@SpringBootApplication
@RestController
@RequestMapping("/student")
public class StudentController {
	
	    @Autowired
	    private StudentDao dao;

	    @PostMapping
	    public Student saveStudent(@RequestBody Student student) {
	        return dao.saveStudent(student);
	    }

	    @GetMapping("/{id}")
	    public Student findStudent(@PathVariable String id) {
	        return dao.getStudent(id);
	    }

	    @PostMapping("/{id}")
		public Student updateStudent(@RequestBody Student student,@PathVariable("id") String studentid) {
			student.setId(studentid);
			return dao.updateStudent(student);
	    }
		
	    @DeleteMapping("/{id}")
	    public String deleteStudentById(@PathVariable String id)   {
	    	return dao.deleteStudent(id);
		}
}

