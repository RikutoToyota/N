package com.example.N.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.N.model.StudentModel;
import com.example.N.model.SubjectModel;
import com.example.N.model.TestModel;
import com.example.N.service.StudentService;
import com.example.N.service.SubjectService;
import com.example.N.service.TestService;

@Controller
public class MainController {
	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	TestService testService;
	
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
		model.addAttribute("studentModel", new StudentModel());

		return "studentsignin";
	}
	//学生登録
	@PostMapping("/studentsignin")
	public String touroku(@ModelAttribute StudentModel studentModel){
		studentModel.setSchoolCd("123");
		studentService.saveStudent(studentModel);
		return "redirect:/kanryou";
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
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	@PostMapping("/login")
	public String  loginfrom() {
		return "top";
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
			subjectModel.setSchoolCd("123");
			  subjectService.saveSubject(subjectModel);
			return "redirect:/kanryou";
		}
		//科目一覧
		@GetMapping("/subjectlist")
			public String getAllsubjects(Model model) {
			List<SubjectModel> subjects = subjectService.getAllSubjects();
			model.addAttribute("subjects", subjects);
			return "subjectlist";
		}
		//科目データ変更機能
		@GetMapping("/subjectedit-{id}")
		    public String showUpdateSubjectForm(@RequestParam Long id, Model model) {
		        SubjectModel subject = subjectService.getSubjectById(id);
		        model.addAttribute("subject", subject);
		        return "subjectedit";
			}
		
		@PostMapping("/subjectedit")
	    public String updateSubject(@ModelAttribute("subject")  SubjectModel subjectModel) {
			subjectModel.setSchoolCd("123");
			subjectService.updateSubject(subjectModel);
	        return "redirect:/subjectlist";
	    }
		//削除機能
		@PostMapping("/subjectsignin/deleteSubject/{id}")
		public String deleteSubject(@PathVariable Long id) {
			subjectService.deleteSubject(id);
			return "redirect:/subjectlist";
		}
		

		// コントローラーのクラス内に追加
		@ModelAttribute("loggedInUsername")
		public String loggedInUsername() {
		    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    return authentication.getName();
		}
		
		
		@GetMapping("/testsignin")
		public String getstudent(StudentModel studentModel, Model model ,SubjectModel subjectModel) {
			model.addAttribute("hoge",studentModel);
			model.addAttribute("subjects",this.subjectService.getAllSubjects());
			return "testsignin";
			}
	
		@PostMapping("/testsignin")
		   public String studentlist(Model model,StudentModel studentmodel,SubjectModel subjectmodel,
				   						@RequestParam("entYear")Integer entYear,
				   						@RequestParam("classNum")String classNum,
				   						@RequestParam("subject")String subject,
				   						@RequestParam("count")Integer count) {
				System.out.print(subject);
				model.addAttribute("studentList",this.studentService.searchStudents2(entYear,classNum));
				model.addAttribute("subjectname",subject);
				model.addAttribute("count",count+"回目");
				model.addAttribute("no",count);
				model.addAttribute("subjectcd",this.subjectService.getsubjectcd(subject));
				
			return "testsignin";
			}
		@PostMapping("/testsignin2")
		public String touroku3(TestModel testModel){
			testModel.setSchoolCd("123");
			testService.saveTest(testModel);
			return "redirect:/";
		}
		
		@GetMapping("/testreference")
		public String getAllTestReference(Model model) {
			System.out.println("0");
			List<TestModel> test = testService.getAllTest();
			System.out.println("1");
			model.addAttribute("test", test);
			System.out.println("2");
			List<StudentModel> students = studentService.getAllStudents();
			model.addAttribute("students", students);
			System.out.println(students);
			System.out.println("3");
			List<SubjectModel> subjects = subjectService.getAllSubjects();
			model.addAttribute("subjects", subjects);
			System.out.println("4");
		 return "testreference";
	}
		@GetMapping("/kanryou")
		public String kanryou() {
			return "kanryou";
		}
	
}

