package bd.edu.seu.studentinformation.controller;

import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.dto.StudentDto;
import bd.edu.seu.studentinformation.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-information-2")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addedStudent(@RequestBody StudentDto studentDto) {
        Student savedStudent = studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
}
