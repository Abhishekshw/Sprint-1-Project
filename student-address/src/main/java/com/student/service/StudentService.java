package com.student.service;


import java.util.List;

import org.springframework.data.domain.Page;


import com.student.entity.Student;
import com.student.model.StudentDTO;

public interface StudentService {

	String createStudent(Student student);
	StudentDTO updateStudent(int id, Student student);
	StudentDTO getStudentById(int id);
	List<StudentDTO> getAllStudents();
	String deleteStudentById(int id);
	void deleteAllStudents();
	
	List<StudentDTO> getStudentByName(String studentName);
	List<StudentDTO> getStudentByEmail(String email);
	
	StudentDTO assignAddressToStudent(int id, int addressId);
	
	// sorting account details using any field
		List<StudentDTO> getAllStudentDetailsWithSort(String field);

		// displaying customer details using pagination
		Page<Student> findStudentWithPagination(int offset, int pageSize);
}
