package com.training.spring.SpringCrudOperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.SpringCrudOperation.model.Student;
import com.training.spring.SpringCrudOperation.model.StudentNotFoundException;
import com.training.spring.SpringCrudOperation.repository.StudentRepository;
import com.training.spring.SpringCrudOperation.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepository;
	
	//get all students
	@GetMapping
	public List<?> getStudent(){
		return studentRepository.findAll();
	}
	
	//get student by id
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) throws StudentNotFoundException{
		Student entity =studentService.getStudentById(id);
		return new ResponseEntity<Student>(entity,new HttpHeaders(),HttpStatus.OK);
	}
	
	//update the student by id
	@PutMapping("/{id}")
	public HttpStatus updateStudent(@PathVariable("id") String id,@RequestBody Student student)throws StudentNotFoundException{
		studentService.updateStudent(id,student);
		return HttpStatus.OK;
	}
	
	//upload the student data
	@PostMapping
	public  ResponseEntity<Student> createOrUpdateEmployee(@RequestBody Student student) throws StudentNotFoundException{
		Student updated =studentService.createOrUpdateStudent(student);
		return new ResponseEntity<Student>(updated,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	//delete the student by id
	@DeleteMapping("/{id}")
	public HttpStatus deleteStudent(@PathVariable("id") String id)throws StudentNotFoundException{
		studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
	
	//filter students based on state
	@GetMapping("/filter")  
	public List<Student> getStudentByAddress(@RequestParam  String state ) throws StudentNotFoundException{
		return studentService.getStudentByAddress(state);
	}
	
	//filter by fee
	@GetMapping("/fee")  
	public List<Student> getStudentBySalary(@RequestParam int fee){
		return studentRepository.findByFeeGreaterThan(fee);
	}
	
}
