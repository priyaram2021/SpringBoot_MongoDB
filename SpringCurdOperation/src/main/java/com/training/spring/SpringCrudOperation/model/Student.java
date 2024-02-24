package com.training.spring.SpringCrudOperation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
	@Id
	private String id;
	private String name;
	private int fee;
	private String state;
	
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {
		super();
	}


	public int getSalary() {
		return fee;
	}

	public void setSalary(int fee) {
		this.fee = fee;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
