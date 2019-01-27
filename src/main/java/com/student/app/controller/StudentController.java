package com.student.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.model.Student;
import com.student.app.service.StudentService;

@RestController
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@GetMapping("/student/detail/{rollNo}")
	public Student getStudent(@PathVariable("rollNo") Long rollNo) {
		StudentController.logger.info("Request received to find Student having RollNo = {}", rollNo);
		return studentService.getStudent(rollNo);
	}

	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student student) {
		StudentController.logger.info("Request received to save student details into DB");
		return studentService.addStudent(student);
	}

	@DeleteMapping("/student/remove/{rollNo}")
	public String removeStudent(@PathVariable("rollNo") Long rollNo) {
		StudentController.logger.info("Request received to delete student details from DB having RollNo = {}", rollNo);
		studentService.removeStudent(rollNo);
		return "Student Have removed having RollNo = " + rollNo;
	}

	@GetMapping("/student/list")
	public List<Student> getAllStudents() {
		StudentController.logger.info("Request received to get all Students");
		return studentService.getAllStudents();
	}

}
