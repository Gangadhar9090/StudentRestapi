package com.student.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entities.Student;
import com.student.repository.StudentRepository;



@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepo;
	
	@PostMapping("/create")
	public void createOneStudent(@RequestBody Student student) {
		studentRepo.save(student);
	}
	
	@GetMapping("/get/{id}")
	public Student getOneStudent(@PathVariable("id") long id) {
		Optional<Student> find = studentRepo.findById(id);
		Student student = find.get();
		return student;
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		java.util.List<Student> findAll = studentRepo.findAll();
		return findAll;
	}
	
}
