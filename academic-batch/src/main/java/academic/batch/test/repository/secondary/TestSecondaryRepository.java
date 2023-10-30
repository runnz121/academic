package academic.batch.test.repository.secondary;

import academic.batch.test.domain.TestEntity;
import academic.batch.test.repository.primary.TestRepositoryCustom;
import academic.batch.config.database.annotation.Secondary;
import org.springframework.data.jpa.repository.JpaRepository;

@Secondary
public interface TestSecondaryRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {
}
