package academic.main._test.service;

import static org.assertj.core.api.Assertions.*;
import academic.main._test.domain.TestEntity;
import academic.main._test.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static academic.main._test.Fixture.TestFixture.testEntity;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TestServiceTest {

    @InjectMocks
    TestService testService;

    @Mock
    TestRepository testRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("테스트 서비스단 테스트")
    void testService() {

        when(testRepository.findAll())
                .thenReturn(Arrays.asList(testEntity));

        final List<TestEntity> actual = testService.findAllTestEntities();

        assertThat(actual).isEqualTo(Arrays.asList(testEntity));
    }
}