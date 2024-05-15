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

	  //検索機能

	    public List<StudentModel> Studentsearch(Integer entYear, String classNum, Boolean isAttend) {

	    List<StudentModel> student = studentRepository.findAll();

	    //入学年度

	    if (entYear!=null) {

	    student = studentRepository.findStudentByEntYear(entYear);

	    }

	    // クラス番号

	    if (classNum != null && !classNum.isEmpty()) {

	    List<StudentModel> classNumStudents = studentRepository.findStudentByClassNum(classNum);

	    student.retainAll(classNumStudents);

	    }

	    // 在学状況で絞り込み

	    if (isAttend != null) {

	    List<StudentModel> isAttendStudents = studentRepository.findStudentByIsAttend(isAttend);

	    student.retainAll(isAttendStudents);

	    }

	    return student;


	    }
	    public List<StudentModel> searchStudents2(Integer entYear, String classNum) {
			// TODO 自動生成されたメソッド・スタブ
			return studentRepository.findByEntYearAndClassNum(entYear, classNum);
			
		}
}