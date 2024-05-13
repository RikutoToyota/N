package com.example.N.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.N.model.TestModel;
import com.example.N.repository.TestRepository;

import io.micrometer.common.lang.NonNull;

@Service
@Transactional(rollbackFor = Exception.class)
public class TestService{
	@Autowired
	TestRepository testRepository;

	//点数一覧
	public List<TestModel> getAllTest() {
		return testRepository.findAll();
	}
	
	//点数新規登録
	 public void saveTest(TestModel TestModel) {
	      testRepository.save(TestModel);
	    }
	// 点数を削除するメソッド
	    public void deleteSubject(@NonNull Long id) {
	        this.testRepository.deleteById(id);
	    }
	    // を検索するメソッド
	    public TestModel getSubjectById(Long id) {
	    	Optional<TestModel> test = testRepository.findById(id);
	    	return test.orElse(null);	
	
}

}