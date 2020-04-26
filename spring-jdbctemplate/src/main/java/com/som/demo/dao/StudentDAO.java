package com.som.demo.dao;

import java.util.List;

import com.som.demo.model.Student;

public interface StudentDAO {

	public void insert(Student student);
	
	public Student getStudentById(int id);
	
	public List<Student> getAllStudents();
}
