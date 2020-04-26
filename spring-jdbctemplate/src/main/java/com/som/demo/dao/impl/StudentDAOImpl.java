package com.som.demo.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.som.demo.dao.StudentDAO;
import com.som.demo.dao.mapper.StudentMapper;
import com.som.demo.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Student student) {
		String query = "insert into student values (?, ?)";
		jdbcTemplate.update(query, new Object[] { student.getId(), student.getName() });
	}

	public Student getStudentById(int id) {
		String query = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(query, new Object[] { id }, new StudentMapper());
		return student;
	}

	/**
	 * We can either provide custom bean mapper like {@code StudentMapper} or use
	 * {@code BeanPropertyRowMapper} which automatically takes care of mapping
	 * resultset to each element of the class
	 */
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> studentList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Student.class));
		return studentList;
	}

}
