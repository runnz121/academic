package academic.main._test.service;

import academic.main._test.domain.TestEntity;
import academic.main._test.domain.TestRedisEntity;
import academic.main._test.repository.TestRedisRepository;
import academic.main._test.repository.TestRepository;
import academic.main.config.database.redis.RedisCacheKey;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final TestRedisRepository testRedisRepository;

    public void saveEntity(TestEntity testEntity) {
        testRepository.save(testEntity);
    }

    public List<TestEntity> findAllTestEntities() {
        return testRepository.findAll();
    }

    public void saveRedisEntity(TestRedisEntity testRedisEntity) {
        testRedisRepository.save(testRedisEntity);
    }

    public List<TestRedisEntity> findTestRedisEntities() {
        return (List<TestRedisEntity>) testRedisRepository.findAll();
    }

    @Cacheable(key = "#id", value = RedisCacheKey.ACADEMIC, cacheManager = "redisCacheManager")
    public TestRedisEntity getCacheableRedisEntity(Long id, TestRedisEntity testRedisEntity) {
        testRedisEntity.updateValue2("redis Cacheable");
        return testRedisEntity;
    }
}
