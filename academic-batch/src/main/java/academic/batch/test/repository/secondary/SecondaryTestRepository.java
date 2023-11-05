package academic.batch.test.repository.secondary;

import academic.batch.test.domain.TestEntity;
import academic.batch.test.repository.primary.PrimaryTestRepositoryCustom;
import academic.batch.config.database.annotation.Secondary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Secondary
public interface SecondaryTestRepository extends JpaRepository<TestEntity, Long>, SecondaryTestRepositoryCustom {

}
