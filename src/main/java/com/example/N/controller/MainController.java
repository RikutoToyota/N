package com.example.N.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.N.dto.StudentRequest;
import com.example.N.model.StudentModel;
import com.example.N.service.StudentService;

@Controller
public class MainController {
	@Autowired
	StudentService studentService;
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
		model.addAttribute("studentRequest", new StudentRequest());
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
	
	@PostMapping("/studentedit")
    public String updateStudent(@ModelAttribute("student")  StudentModel studentModel) {
	    studentService.updateStudent(studentModel);
        return "redirect:/studentlist";
    }

}