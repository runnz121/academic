package academic.main.test.service;

import academic.main.test.domain.TestEntity;
import academic.main.test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void saveEntity(TestEntity testEntity) {
        testRepository.save(testEntity);
    }

    public List<TestEntity> findAllTestEntities() {
        return testRepository.findAll();
    }
}
