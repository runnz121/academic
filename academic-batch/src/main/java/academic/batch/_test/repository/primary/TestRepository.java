package academic.batch._test.repository.primary;

import academic.batch._test.domain.TestEntity;
import academic.batch.config.database.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {
}
