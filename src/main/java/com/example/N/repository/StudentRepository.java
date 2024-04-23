package com.example.N.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.N.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	List<StudentModel> findStudentByEntYear(Integer entYear);
	List<StudentModel> findStudentByClassNum(String classNum);
	List<StudentModel> findStudentByIsAttend(Boolean isAttend);
}

