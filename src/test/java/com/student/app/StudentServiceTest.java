package com.student.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.app.dao.StudentRepository;
import com.student.app.model.Student;
import com.student.app.service.StudentService;
import com.student.app.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@TestConfiguration
	static class StudentServiceApplicationTestsContextConfig {

		@Bean
		public StudentService studentService() {
			return new StudentServiceImpl();
		}
	}

	@Autowired
	StudentService studentService;

	@MockBean
	StudentRepository studentRepository;

	@Test
	public void testAddStudent() {
		Student newStudent = new Student();
		newStudent.setfName("Viraj");
		newStudent.setlName("Nimbalkar");
		newStudent.setStandard("F.Y.B.E.");
		newStudent.setTotalMarks("800");

		final Student student3 = new Student(1L, "Viraj", "Nimbalkar", "F.Y.B.E.", "800", "Pune University");
		Mockito.when(studentRepository.save(newStudent)).thenReturn(student3);

		newStudent = studentService.addStudent(newStudent);
		assertEquals(new Long(1L), newStudent.getRollNo());
		assertEquals("Viraj", newStudent.getfName());
		assertEquals("Nimbalkar", newStudent.getlName());
		assertEquals("F.Y.B.E.", newStudent.getStandard());
		assertEquals("800", newStudent.getTotalMarks());
		assertEquals("Pune University", newStudent.getUniversityName());
	}

	@Test
	public void testGetStudent() {

		final Student student1 = new Student(1L, "Vishal", "Nimbalkar", "F.Y.B.E.", "650", "Pune University");
		Mockito.when(studentRepository.findByRollNo(anyLong())).thenReturn(student1);

		final Student student = studentService.getStudent(1L);
		assertEquals(new Long(1L), student.getRollNo());
		assertEquals("Vishal", student.getfName());
		assertEquals("Nimbalkar", student.getlName());
		assertEquals("F.Y.B.E.", student.getStandard());
		assertEquals("650", student.getTotalMarks());
		assertEquals("Pune University", student.getUniversityName());
	}

	@Test
	public void testGetAllStudent() {
		final Student student1 = new Student(1L, "Vishal", "Nimbalkar", "F.Y.B.E.", "650", "Pune University");
		final Student student2 = new Student(2L, "Bhushan", "Chaudhari", "F.Y.B.E.", "750", "Pune University");
		List<Student> students = Arrays.asList(student1, student2);
		Mockito.when(studentRepository.findAll()).thenReturn(students);

		students = studentService.getAllStudents();
		assertNotNull(students);
		assertEquals(2, students.size());
	}

}
