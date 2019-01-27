package com.student.app.service;

import java.util.List;

import com.student.app.model.Student;

public interface StudentService {
	public Student getStudent(Long rollNo);

	public Student addStudent(Student student);

	public void removeStudent(Long rollNo);

	public List<Student> getAllStudents();
}
