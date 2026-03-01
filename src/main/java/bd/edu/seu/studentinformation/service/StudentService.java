package bd.edu.seu.studentinformation.service;

import bd.edu.seu.studentinformation.model.Name;
import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.dto.StudentDto;
import bd.edu.seu.studentinformation.repository.NameRepository;
import bd.edu.seu.studentinformation.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final NameRepository nameRepository;

    public StudentService(StudentRepository studentRepository, NameRepository nameRepository) {
        this.studentRepository = studentRepository;
        this.nameRepository = nameRepository;
    }

    public void applyDto(Student student, StudentDto studentDto) {
        Name name = new Name();
        name.setFirstName(studentDto.getFirstName());
        name.setLastName(studentDto.getLastName());

        student.setName(name);
        student.setBatch(studentDto.getBatch());
        student.setProgram(studentDto.getProgram());
    }

    public Student saveStudent(StudentDto studentDto) {
        Student student = new Student();
        applyDto(student, studentDto);
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Student findStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public Student updateById(int id, StudentDto studentDto) {
        Student existing = findStudentById(id);
        applyDto(existing, studentDto);
        return studentRepository.save(existing);
    }

}
