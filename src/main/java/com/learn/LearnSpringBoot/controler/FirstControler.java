package com.learn.LearnSpringBoot.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.LearnSpringBoot.entity.Student;

//@controller  @RestController

@RestController
public class FirstControler {
	
	@GetMapping ("/hello")
	
	public String hello()
	{
		return "Hello";
	}
	@GetMapping("/student")
	public Student getStudent()
	{
		Student s=new Student();
		s.setId(101);
		s.setMarks(50);
		s.setName("Nisha");
		return s;
	}
	@GetMapping("/all-students")
	public List<Student> allStudent()
	{
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student(101, "Nisha", 60));
		student.add(new Student(102, "Janki", 80));
		return student;
	}
	@GetMapping("/get-all-students")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student(101, "Nisha", 60));
		student.add(new Student(102, "Janki", 80));
		return new ResponseEntity<List<Student>>(student,HttpStatus.FOUND);
	}
	
	@GetMapping("/Students/{id}")
	public String learnPathVariable(@PathVariable int id)
{
	System.out.println(id);
	return "Data fetched successfully";
	}
	
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student )
	{
		System.out.println(student);
		return student;
	}
	
	// ResponseEntity<Students> HttpStatus [enum.]
	
	@PostMapping("/add-student")
	public ResponseEntity<Student> addStudentWithResponseEntity(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
		
	}
	
	
	

}
