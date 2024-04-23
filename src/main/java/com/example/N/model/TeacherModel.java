package com.example.N.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name="teacher") 
public class TeacherModel { 
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(length = 10, nullable = false)
	private String teacherId;
	
	@Column(length = 256, nullable = true)
	private String password;
	
	@Column(length = 10, nullable = true)
	private String name;
	
	@Column(length = 3, nullable = true)
	private String schoolCd;
}