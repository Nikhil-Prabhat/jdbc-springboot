package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.Student;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public int insert(Student student) {
		String sql="insert into login values(?,?)";
		int insert=jdbctemplate.update(sql,student.getId(),student.getName());
		return insert;
	}

	@Override
	public int delete(int id) {
		String sql="delete from login where id=?";
		int delete=jdbctemplate.update(sql,id);
		return delete;
	}

	@Override
	public int update(Student student) {
		String sql="update login set name=? where id=?";
		int update=jdbctemplate.update(sql,student.getName(),student.getId());
		return update;		
	}

	@Override
	public List<Student> getall() {
		String sql = "select * from login";
		Studentrowmapper rmp = new Studentrowmapper();
		List<Student> students = jdbctemplate.query(sql, rmp);
		return students;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

}
