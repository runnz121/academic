package academic.main.classes.infrastructure.persistence.repository;

import academic.main.classes.domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
