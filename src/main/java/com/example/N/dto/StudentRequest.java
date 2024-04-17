package com.example.N.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentRequest implements Serializable{
	
	private Long id;
	
	private String no;
	
	private int entYear;
	
	private String classNum;
	
	private String isAttend;
	
	private String schoolCd;
	
}
