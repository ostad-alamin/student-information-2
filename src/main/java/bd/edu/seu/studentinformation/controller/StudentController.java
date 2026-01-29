package bd.edu.seu.studentinformation.controller;

import bd.edu.seu.studentinformation.model.Name;
import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.repository.StudentRepository;
import bd.edu.seu.studentinformation.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "student-info";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Student student,
                       Model model) {

        Student save = studentService.save(student);
        return "success";
    }
}
