package academic.batch.test.repository.primary;

import academic.batch.test.domain.TestEntity;

import java.util.List;

public interface PrimaryTestRepositoryCustom {

    List<TestEntity> findAlltestEntityList();

}
