package academic.batch.test.repository.secondary;

import academic.batch.test.domain.TestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SecondaryTestRepositoryCustom {

    List<TestEntity> findAlltestEntityList();

}
