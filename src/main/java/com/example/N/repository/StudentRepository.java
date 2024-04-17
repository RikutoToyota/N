package com.example.N.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.N.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long>{
	
}