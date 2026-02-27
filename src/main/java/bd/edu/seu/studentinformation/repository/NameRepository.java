package bd.edu.seu.studentinformation.repository;

import bd.edu.seu.studentinformation.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends JpaRepository<Name, Integer> {
}
