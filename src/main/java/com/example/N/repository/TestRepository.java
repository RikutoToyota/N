package com.example.N.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.N.model.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long>{

}
