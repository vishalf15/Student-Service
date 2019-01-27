package com.student.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.student.app.dao.StudentRepository;
import com.student.app.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Value("${university.name}")
	private String university;

	@Value("${get.student.log}")
	private String getStudMsg;

	@Value("${add.student.log}")
	private String addStudMsg;

	@Value("${remove.student.log}")
	private String removeStudMsg;

	@Value("${list.all.log}")
	private String listAllStudMsg;

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student getStudent(Long rollNo) {
		StudentServiceImpl.logger.info(getStudMsg, rollNo);
		return studentRepo.findByRollNo(rollNo);
	}

	@Override
	public Student addStudent(Student student) {
		StudentServiceImpl.logger.info(addStudMsg, student.getfName(), student.getlName(), student.getStandard(),
				student.getTotalMarks());
		student.setUniversityName(university);
		return studentRepo.save(student);
	}

	@Override
	public void removeStudent(Long rollNo) {
		StudentServiceImpl.logger.info(removeStudMsg, rollNo);
		studentRepo.delete(rollNo);
	}

	@Override
	public List<Student> getAllStudents() {
		StudentServiceImpl.logger.info(listAllStudMsg);
		return studentRepo.findAll();
	}
}
