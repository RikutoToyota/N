package com.example.N.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.N.repository.TestRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class TestService{
	@Autowired
	TestRepository testRepository;
	
	
}
