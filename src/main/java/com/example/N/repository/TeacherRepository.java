package com.example.N.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.N.model.TeacherModel;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
    TeacherModel findByTeacherIdAndPassword(String teacherId, String password);
    TeacherModel findByTeacherIdEquals(String teacherId);
}

