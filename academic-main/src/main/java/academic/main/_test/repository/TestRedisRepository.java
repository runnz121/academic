package academic.main._test.repository;

import academic.main._test.domain.TestRedisEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRedisRepository extends CrudRepository<TestRedisEntity, String> {
}
