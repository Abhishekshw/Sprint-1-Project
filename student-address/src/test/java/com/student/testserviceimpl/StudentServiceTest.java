package com.student.testserviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.Converter;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Converter converter;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@Test
	void testSaveStudent()
	{
		Student student = new Student();
		student.setStudentName("Shawin");
		student.setEmail("shawin@gmail.com");
		student.setPhone(9876543210l);
//		Student student = Student.builder().studentName("shawin").email("shawin@gmail.com")
//				.phone(9876543210l).build();
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertThat(studentService.createStudent(student)).isEqualTo("Student details saved successfully");
		}

}
