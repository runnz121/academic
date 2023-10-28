package academic.main._test.Fixture;

import academic.main._test.domain.TestEntity;
import academic.main._test.domain.TestRedisEntity;

public class TestFixture {

    public static TestEntity testEntity = TestEntity.builder()
            .name("test")
            .value("value")
            .build();

    public static TestRedisEntity testRedisEntity = TestRedisEntity.builder()
            .name("testRedis")
            .value("redisValue")
            .build();
}
