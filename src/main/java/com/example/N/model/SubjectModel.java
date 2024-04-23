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
@Table(name="subject")
public class SubjectModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(length = 3, nullable = false)
	private String schoolCd;
	
	@Column(length = 3, nullable = false)
	private String cd;
	
	@Column(length = 20, nullable = true)
	private String name;
}
