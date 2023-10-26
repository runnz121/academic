package academic.main._test.Fixture;

import academic.main._test.domain.TestEntity;

public class TestFixture {

    public static TestEntity testEntity = TestEntity.builder()
            .name("test")
            .value("value")
            .build();
}
