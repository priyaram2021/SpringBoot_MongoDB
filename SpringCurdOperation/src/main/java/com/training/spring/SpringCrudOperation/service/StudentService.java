package com.training.spring.SpringCrudOperation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.spring.SpringCrudOperation.model.Student;
import com.training.spring.SpringCrudOperation.model.StudentNotFoundException;
import com.training.spring.SpringCrudOperation.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public Student getStudentById(String id) throws StudentNotFoundException {
		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException("No Student record exist for given id");
		}
	}

	public Student createOrUpdateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> students = studentRepository.findById(student.getId());
		if (students.isPresent()) {
			Student newStudent = students.get();
			newStudent.setId(student.getId());
			newStudent.setName(student.getName());

			newStudent = studentRepository.save(newStudent);
			return newStudent;
		} else {
			student = studentRepository.save(student);
			return student;

		}

	}

	public void deleteStudent(String id) throws StudentNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			studentRepository.deleteById(id);
		} else {
			throw new StudentNotFoundException("No Student record exist for given id ");
		}
	}

	public void updateStudent(String id, Student stu) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			Student s = student.get();
			s.setId(id);
			s.setName(stu.getName());
			studentRepository.save(s);
		} else {
			throw new StudentNotFoundException("No Student record exist for given id ");
		}
	}

	public List<Student> getStudentByAddress(String state) {
		List<Student> students = studentRepository.findStudentByState(state);

		return students;
	}
}
