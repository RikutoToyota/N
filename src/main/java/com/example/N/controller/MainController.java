package com.example.N.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.N.model.StudentModel;
import com.example.N.model.SubjectModel;
import com.example.N.service.StudentService;
import com.example.N.service.SubjectService;

@Controller
public class MainController {
	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;
	
	//トップ
	@GetMapping("/")
	public String top() {
		return "top";
	}
	//学生一覧
	@GetMapping("/studentlist")
		public String getAllStudents(Model model) {
		List<StudentModel> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "studentlist";
	}
	//学生登録フォーム
	@GetMapping("/studentsignin")
	public String studentsignin(Model model) {
		model.addAttribute("StudentModel", new StudentModel());
		return "studentsignin";
	}
	//学生登録
	@PostMapping("/studentsignin")
	public String touroku(@ModelAttribute StudentModel studentModel){
		
		studentService.saveStudent(studentModel);
		return "redirect:/";
	}
	//学生データ変更機能
	@GetMapping("/studentedit-{id}")
	    public String showUpdateStudentForm(@RequestParam Long id, Model model) {
	        StudentModel student = studentService.getStudentById(id);
	        model.addAttribute("student", student);
	        return "studentedit";
		}
	//学生検索
	@PostMapping("/studentedit")
    public String updateStudent(@ModelAttribute("student")  StudentModel studentModel) {
	    studentService.updateStudent(studentModel);
        return "redirect:/studentlist";
    }
	@GetMapping("/studentsearch")

	public ResponseEntity<List<StudentModel>> Studentsearch(

	@RequestParam(value = "entYear", required = false) Integer entYear,

	@RequestParam(value = "classNum", required = false) String classNum,

	@RequestParam(value = "isAttend", required = false) Boolean isAttend) {

	List<StudentModel> result = studentService.Studentsearch(entYear, classNum, isAttend);

	return ResponseEntity.ok(result);

	}

	@PostMapping("/studentsearch")

	public String handleListActions(

	@RequestParam(name = "entYear", required = false) Integer entYear,

	@RequestParam(name = "classNum", required = false) String classNum,

	@RequestParam(name = "isAttend", required = false) Boolean isAttend,

	Model model) {

	// 検索操作の場合

	List<StudentModel> student = studentService.Studentsearch(entYear, classNum, isAttend);

	System.out.println("検索結果: " + student);

	model.addAttribute("searchedStudents", student);

	return "studentList"; // 検索結果のテンプレート名を返す

	}
	
	//科目登録フォーム
		@GetMapping("/subjectsignin")
		public String subjectsignin(Model model) {
			model.addAttribute("SubjectModel" , new SubjectModel());
			return "subjectsignin";
		}
		//科目登録
		@PostMapping("/subjectsignin")
		public String touroku2(@ModelAttribute SubjectModel subjectModel){
			subjectModel.setSchoolCd("aaa");
			  subjectService.saveSubject(subjectModel);
			return "redirect:/";
		}
		//科目一覧
		@GetMapping("/subjectlist")
			public String getAllsubjects(Model model) {
			List<SubjectModel> subjects = subjectService.getAllSubjects();
			model.addAttribute("subjects", subjects);
			return "subjectlist";
		}
		//学生データ変更機能
		@GetMapping("/subjectedit-{id}")
		    public String showUpdateSubjectForm(@RequestParam Long id, Model model) {
		        SubjectModel subject = subjectService.getSubjectById(id);
		        model.addAttribute("subject", subject);
		        return "subjectedit";
			}
		
		@PostMapping("/subjectedit")
	    public String updateSubject(@ModelAttribute("subject")  SubjectModel subjectModel) {
			subjectModel.setSchoolCd("aaa");
			subjectService.updateSubject(subjectModel);
	        return "redirect:/subjectlist";
	    }
		//削除機能
		@PostMapping("/subjectsignin/deleteSubject/{id}")
		public String deleteSubject(@PathVariable Long id) {
			subjectService.deleteSubject(id);
			return "redirect:/subjectlist";
		}
		//controller
		@GetMapping("/login")
			public String login() {
				
				return "login";
			}
			@PostMapping("/login")
			public String  loginfrom() {
				return "redirect:/top";
			}
		 
	}