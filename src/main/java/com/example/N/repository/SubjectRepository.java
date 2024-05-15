package com.example.N.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.N.model.SubjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long>{
	SubjectModel findByName(String cd);
}