package bd.edu.seu.studentinformation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id")
    private Name name;
    private String program;
    private String batch;

    public Student(Name name, String program, String batch) {
        this.name = name;
        this.program = program;
        this.batch = batch;
    }
}
