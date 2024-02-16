package academic.main.user.infrastructure.persistence.repository;

import academic.main.user.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
