package academic.main.classes.infrastructure.persistence.repository;

import academic.main.classes.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
