package academic.main._test.service;

import academic.main._test.domain.TestEntity;
import academic.main._test.domain.TestRedisEntity;
import academic.main._test.repository.TestRedisRepository;
import academic.main._test.repository.TestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static academic.main._test.Fixture.TestFixture.testEntity;
import static academic.main._test.Fixture.TestFixture.testRedisEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("테스트 서비스 단을 확인하는 테스트")
@ExtendWith(MockitoExtension.class)
class TestServiceTest {

    @InjectMocks
    TestService testService;
    @Mock
    TestRepository testRepository;
    @Mock
    TestRedisRepository testRedisRepository;

    @Test
    @DisplayName("테스트 객체를 갖고오는지 확인하는 테스트")
    void testService() {

        when(testRepository.findAll())
                .thenReturn(Arrays.asList(testEntity));

        final List<TestEntity> actual = testService.findAllTestEntities();

        assertThat(actual).isEqualTo(Arrays.asList(testEntity));
    }

    @Test
    @DisplayName("테스트 레디스 엔티티를 갖고오는지 확인하는 테스트")
    void setTestRedisRepository() {

        when(testRedisRepository.findAll())
                .thenReturn(Arrays.asList(testRedisEntity));

        final List<TestRedisEntity> actual = testService.findTestRedisEntities();

        assertThat(actual).isEqualTo(Arrays.asList(testRedisEntity));
    }

    @Test
    @DisplayName("테스트 레디스 엔티티 cacheable 값을 갖고오는지 확인하는 테스트")
    void getCacheableRedis() {

        Long givenId = 1L;
        TestRedisEntity givenTestRedisEntity = testRedisEntity;
        String actualValue = "redis Cacheable";

        final TestRedisEntity actual = testService.getCacheableRedisEntity(givenId,givenTestRedisEntity);

        assertThat(actual.getValue2()).isEqualTo(actualValue);
    }
}