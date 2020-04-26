package com.som.demo.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.som.demo.dao.TeacherDAO;
import com.som.demo.model.Teacher;

/**
 * <p>
 * If we extend to {@code JdbcDaoSupport} then we don't need to set jdbcTemplate
 * like in class {@link StudentDAOImpl}. We only need to inject dataSource into
 * {@link TeacherDAOImpl} bean defined in beans.xml
 * </p>
 * 
 * @author somdutt
 *
 */
public class TeacherDAOImpl extends JdbcDaoSupport implements TeacherDAO {

	public void insert(Teacher teacher) {
		String query = "insert into teacher values(?, ?)";
		getJdbcTemplate().update(query, new Object[] { teacher.getId(), teacher.getName() });
	}

	public Teacher getTeacherById(int id) {
		String query = "select * from teacher where id= ?";
		@SuppressWarnings("unchecked")
		Teacher teacher = (Teacher) getJdbcTemplate().queryForObject(query, new Object[] {},
				new BeanPropertyRowMapper<Teacher>(Teacher.class));
		return teacher;
	}

	public List<Teacher> getAllTeacher() {
		String query = "select * from teacher";
		List<Teacher> teacherList = getJdbcTemplate().query(query, new BeanPropertyRowMapper<Teacher>(Teacher.class));
		return teacherList;
	}

}
