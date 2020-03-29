package com.cognizant.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.model.Student;

@Component
public interface StudentDao {
	
	public int insert(Student student);
	public int delete(int id);
	public int update(Student student);
	public List<Student> getall();

}
