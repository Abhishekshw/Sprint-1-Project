package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("from Student where email=:e")
	List<Student> getStudentByEmail(@Param("e") String email);
	
	//@Query("from Student where studentName=:s")
	@Query("from Student where lower(studentName) like :s%")
	List<Student> getStudentByName(@Param("s") String studentName);
	
//	@Query("select p from Student p where p.studentName=?1")
//	List<Student> getStudentByName(String studentName);
}
