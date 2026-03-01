package bd.edu.seu.studentinformation.service;

import bd.edu.seu.studentinformation.model.Name;
import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.dto.StudentDto;
import bd.edu.seu.studentinformation.repository.NameRepository;
import bd.edu.seu.studentinformation.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final NameRepository nameRepository;

    public StudentService(StudentRepository studentRepository, NameRepository nameRepository) {
        this.studentRepository = studentRepository;
        this.nameRepository = nameRepository;
    }

//    public Student save(StudentDto student) {
//        Name name = new Name(student.getFirstName(), student.getLastName());
//        nameRepository.save(name);
//
//        Student savedStudent = new Student();
//        savedStudent.setName(name);
//        savedStudent.setBatch(student.getBatch());
//        savedStudent.setProgram(student.getProgram());
//
//        return studentRepository.save(savedStudent);
//    }

    public Student addStudent(StudentDto studentDto) {
        Student student = new Student();
        applyDto(student, studentDto);
        return studentRepository.save(student);
    }

    public void applyDto(Student student, StudentDto studentDto) {
        Name name = new Name();
        name.setFirstName(studentDto.getFirstName());
        name.setLastName(studentDto.getLastName());

        student.setName(name);
        student.setBatch(studentDto.getBatch());
        student.setProgram(studentDto.getProgram());

    }
}
