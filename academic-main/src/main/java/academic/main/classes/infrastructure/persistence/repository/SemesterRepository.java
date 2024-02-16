package academic.main.classes.infrastructure.persistence.repository;

import academic.main.classes.domain.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
