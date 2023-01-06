package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.entity.Student;
import com.student.exception.ResourceNotFoundException;
import com.student.model.StudentDTO;
import com.student.repository.AddressRepository;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.Converter;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private Converter converter;

	private static final Logger l = LoggerFactory.getLogger(Student.class);

	@Override
	public String createStudent(Student student) {
		String message = null;

		l.info("Student  " + student.toString() + " added at date : " + new Date());
		studentRepository.save(student);
		if (student != null) {
			message = "Student details saved successfully";
		}
		return message;
	}

	@Override
	public StudentDTO updateStudent(int id, Student student) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setPhone(student.getPhone());
		existingStudent.setEmail(student.getEmail());

		studentRepository.save(existingStudent);
		l.info("Student with Id" + id + " Updated at date : " + new Date());
		return converter.convertToStudentDTO(existingStudent);

	}

	@Override
	public StudentDTO getStudentById(int id) {
		Student getS = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));

		l.info("Student with Id" + id + " fetching on date : " + new Date());
		return converter.convertToStudentDTO(getS);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students = studentRepository.findAll();

		List<StudentDTO> sDTO = new ArrayList<>();
		for (Student s : students) {
			sDTO.add(converter.convertToStudentDTO(s));
		}
		l.info("Student " + sDTO.toString() + " fetching on date : " + new Date());
		return sDTO;
	}

	@Override
	public String deleteStudentById(int id) {
		String message = null;
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			studentRepository.deleteById(id);
			message = "Student details deleted successfully";
			l.info("Student " + student.toString() + " deleted on date : " + new Date());
		} else {
			throw new ResourceNotFoundException("Student", "ID", id);
		}
		return message;
	}

	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
		l.info("All Student are deleted on date:  " + new Date());
	}

	@Override
	public List<StudentDTO> getStudentByName(String studentName) {
		List<Student> students = studentRepository.getStudentByName(studentName);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for (Student s : students) {
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		l.info("Student " + studentDTO.toString() + " fetching by name on date : " + new Date());
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getStudentByEmail(String email) {
		List<Student> stu = studentRepository.getStudentByEmail(email);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for (Student s : stu) {
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		l.info("Student " + studentDTO.toString() + " fetching by email on date : " + new Date());
		return studentDTO;
	}

	@Override
	public StudentDTO assignAddressToStudent(int id, int addressId) {
		Student student = studentRepository.findById(id).get();
		Address address = addressRepository.findById(addressId).get();
		student.setAddress(address);
		studentRepository.save(student);
		l.info("Student " + student.toString() + "is assign to address " + address.toString() + " on date : "
				+ new Date());
		return converter.convertToStudentDTO(student);
	}

	@Override
	public List<StudentDTO> getAllStudentDetailsWithSort(String field) {
		List<Student> Students = studentRepository.findAll(Sort.by(field));
		List<StudentDTO> StudentDTOs = new ArrayList<>();

		// for Each Loop
		for (Student Student : Students) {

			StudentDTOs.add(converter.convertToStudentDTO(Student));
		}

		return StudentDTOs;
	}

	@Override
	public Page<Student> findStudentWithPagination(int offset, int pageSize) {
		Page<Student> student = studentRepository.findAll(PageRequest.of(offset, pageSize));
		return student;

	}

}
