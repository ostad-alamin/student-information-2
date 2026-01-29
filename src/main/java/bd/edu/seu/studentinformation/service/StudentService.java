package bd.edu.seu.studentinformation.service;

import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
