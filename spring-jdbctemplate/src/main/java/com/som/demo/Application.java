package com.som.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.som.demo.dao.StudentDAO;
import com.som.demo.dao.TeacherDAO;
import com.som.demo.model.Student;
import com.som.demo.model.Teacher;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		TeacherDAO teacherDAO = (TeacherDAO) context.getBean("teacherDAO");
		Student student = studentDAO.getStudentById(1);
		System.out.println(student);
		studentDAO.insert(new Student(3, "Ramesh"));
		System.out.println(studentDAO.getAllStudents());

		System.out.println("Inserting data into teachers table..!!");
		teacherDAO.insert(new Teacher(1, "Marc"));
		teacherDAO.insert(new Teacher(2, "Harry"));
		System.out.println(teacherDAO.getAllTeacher());
	}
}
