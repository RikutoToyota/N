package com.example.N.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.N.model.SubjectModel;
import com.example.N.repository.SubjectRepository;

import io.micrometer.common.lang.NonNull;

@Service
@Transactional(rollbackFor = Exception.class)
public class SubjectService {
	@Autowired
	SubjectRepository subjectRepository;
	
	//学科一覧
	public List<SubjectModel> getAllSubjects() {
		return subjectRepository.findAll();
	}
	
	//学科新規登録
	 public void saveSubject(SubjectModel SubjectModel) {
	      subjectRepository.save(SubjectModel);
	    }
	// 学生を削除するメソッド
	    public void deleteSubject(@NonNull Long id) {
	        this.subjectRepository.deleteById(id);
	    }
	    // 学生を検索するメソッド
	    public SubjectModel getSubjectById(Long id) {
	    	Optional<SubjectModel> subject = subjectRepository.findById(id);
	    	return subject.orElse(null);
	    }

	    // 更新
	    public void updateSubject(SubjectModel subjectModel) {
	    	
	        subjectRepository.save(subjectModel);
	    }
	    public String getsubjectcd(String cd) {
	    	SubjectModel aaa = subjectRepository.findByName(cd);
	    	return aaa.getCd();
	    }
}
