package com.student.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public Student findByRollNo(Long rollNo);

}
