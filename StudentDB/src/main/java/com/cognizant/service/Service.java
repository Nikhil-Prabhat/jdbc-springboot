package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Student;

public interface Service {

	public int insert(Student student);

	public int delete(int id);

	public int update(Student student);

	public List<Student> getall();
}
