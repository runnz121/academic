package academic.main._test.service;

import academic.main._test.domain.TestEntity;
import academic.main._test.domain.TestRedisEntity;
import academic.main._test.repository.TestRedisRepository;
import academic.main._test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
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

    public List<TestRedisEntity> findTestRedisEntity() {
        return (List<TestRedisEntity>) testRedisRepository.findAll();
    }
}
