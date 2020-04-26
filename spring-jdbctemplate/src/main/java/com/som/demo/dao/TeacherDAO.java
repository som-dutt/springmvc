package com.som.demo.dao;

import java.util.List;

import com.som.demo.model.Teacher;

public interface TeacherDAO {

	public void insert(Teacher teacher);
	public Teacher getTeacherById(int id);
	public List<Teacher> getAllTeacher();
}
