package com.datumsolutions.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.datumsolutions.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	 public static final String HASH_KEY = "Student";
	    @Autowired
	    private RedisTemplate<String, Object> template;

	    public Student saveStudent(Student student){
	        template.opsForHash().put(HASH_KEY,student.getId(),student);
	        return student;
	    }
	    public Student getStudent(String id){
	        return  (Student) template.opsForHash().get(HASH_KEY,id);
	    }
		
		 public Student updateStudent(Student student){
		 template.opsForHash().put(HASH_KEY,student.getId(),student); 
		 return student;		 		 
		 }
		 
	    public String deleteStudent(String id){
	         template.opsForHash().delete(HASH_KEY,id);
	        return "Student removed !!";
	    }
}
