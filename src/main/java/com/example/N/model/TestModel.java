package com.example.N.model;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="test")
public class TestModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(length = 10, nullable = false)
	private String studentNo;
	@ManyToOne
	@JoinColumn(name="studentNo",referencedColumnName="no",insertable=false,updatable=false)
	private StudentModel student;
	
	@Column(length = 3, nullable = false)
	private String subjectCd;
	@ManyToOne
	@JoinColumn(name="subjectCd",referencedColumnName="cd",insertable=false,updatable=false)
	private SubjectModel subject;
	
	@Column(length = 10, nullable = false)
	private String schoolCd;
	@ManyToOne
	@JoinColumn(name="schoolCd",referencedColumnName="cd",insertable=false,updatable=false)
	private SchoolModel school;
	@Column(length = 10, nullable = false)
	private Integer no;
	
	@Column(length = 10, nullable = false)
	private Integer point;
	
	@Column(length = 5, nullable = false)
	private String classNum;
//	@ManyToOne
//	@JoinColumn(name="classNum",referencedColumnName="classNum",insertable=false,updatable=false)
//	private StudentModel studentClass;
	
}
