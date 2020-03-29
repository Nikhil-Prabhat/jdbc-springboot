package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Component
public class ServiceImpl implements Service {

	@Autowired
	private StudentDao studentdao;

	@Override
	public int insert(Student student) {

		int insert = getStudentdao().insert(student);
		return insert;
	}

	@Override
	public int delete(int id) {
		int delete = getStudentdao().delete(id);
		return delete;
	}

	@Override
	public int update(Student student) {
		int update = getStudentdao().update(student);
		return update;
	}

	@Override
	public List<Student> getall() {
		
		List<Student> students= studentdao.getall();
		return students;
	}

	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

}
