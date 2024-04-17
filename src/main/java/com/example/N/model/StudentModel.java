package com.example.N.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name="student") 
public class StudentModel implements Serializable{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(length = 10, nullable = false)
	private String no; 
	
	@Column(length = 10, nullable = true) 
	private String name;
	
	@Column(length = 10, nullable = true) 
	private int entYear;
	
	@Column(length = 3, nullable = true) 
	private String classNum;
	
	@Column(nullable = true) 
	private Boolean isAttend;
	
	@Column(length = 3, nullable = true) 
	private String schoolCd;
	
}
	
