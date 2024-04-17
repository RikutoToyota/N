package com.example.N.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.N.model.StudentModel;
import com.example.N.repository.StudentRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	//学生一覧
	public List<StudentModel> getAllStudents() {
		return studentRepository.findAll();
	}
	
	//学生新規登録
	 public void saveStudent(StudentModel studentModel) {
	      studentRepository.save(studentModel);
	    }
	 
	    // 特定の学生を取得するメソッド
//	  public Optional<StudentModel> getStudent(String no) {
//	        return studentRepository.findById(no);
//	    }
	  
	    // 学生を削除するメソッド
	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }
	    // 学生を検索するメソッド
	    public StudentModel getStudentById(Long id) {
	    	Optional<StudentModel> student = studentRepository.findById(id);
	    	return student.orElse(null);
	    }

	    // 更新
	    public void updateStudent(StudentModel studentModel) {
	    	
	        studentRepository.save(studentModel);
	    }
}