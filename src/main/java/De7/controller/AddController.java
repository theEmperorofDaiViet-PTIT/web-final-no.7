package De7.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import De7.data.StudentRepository;
import De7.entity.Student;

@SessionAttributes("input")
@Controller
public class AddController {
	
	@Autowired
	private StudentRepository repo;
	private Student student;
	
	@ModelAttribute("input")
	public Student student() {
		return new Student();
	}
	
	@GetMapping("/")
	public String home(Model model, @ModelAttribute Student input){
		model.addAttribute("student",new Student());
		return "index";
	}
	
	@PostMapping("/addStudent")
	public String addRequest(@Valid Student student, Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "index";
		}
		if(repo.getById(student.getId()) != null) {
			model.addAttribute("message", "Id existed!");
			return "index";
		}
		this.student = student;
		model.addAttribute("student", student);
		return "confirm";
	}
	
	@PostMapping("/addStudent/confirm")
	public String add(@RequestParam(name="action") String action) {
		if(action.equals("Yes")) {
			repo.save(this.student);
		}
		return "redirect:/";
	}
	
}
