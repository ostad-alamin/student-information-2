package bd.edu.seu.studentinformation.controller;

import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.dto.StudentDto;
import bd.edu.seu.studentinformation.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-information-2")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> create(@RequestBody StudentDto studentDto) {
        Student savedStudent = studentService.saveStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/get/all")
    public List<Student> getAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentService.deleteById(id);
        return "Successfully deleted";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody StudentDto Dto) {
        Student student = studentService.updateById(id, Dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
