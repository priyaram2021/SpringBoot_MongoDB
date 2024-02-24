package com.training.spring.SpringCrudOperation.repository;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.spring.SpringCrudOperation.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findStudentByState(String state);

//	@Field("find.({fee:{$gt:?}}")
	
	// it returns the data, where the fee=entered fee
    List<Student> findByFeeGreaterThan(int fee);

}