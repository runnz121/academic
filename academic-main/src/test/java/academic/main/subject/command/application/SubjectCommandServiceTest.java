package academic.main.subject.command.application;

import academic.main.classes.infrastructure.persistence.repository.SubjectRepository;
import academic.main.support.JpaTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static academic.main.fixture.subject.SubjectFixture.과목_생성_요청;

@DisplayName("과목생성 서비스 테스트")
public class SubjectCommandServiceTest extends JpaTestSupport {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    @DisplayName("과목을 저장하는지 확인하는 테스트")
    void createSubjectTest() {

        subjectRepository.save(과목_생성_요청.toEntity());
    }
}
