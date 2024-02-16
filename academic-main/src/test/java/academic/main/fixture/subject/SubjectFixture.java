package academic.main.fixture.subject;

import academic.main.classes.ui.dto.request.CreateSubjectRequest;

import java.util.List;

import static academic.main.classes.domain.SubjectCode.MATH;
import static academic.main.classes.domain.SubjectType.ESSENTIAL;

public class SubjectFixture {

    public static CreateSubjectRequest 과목_생성_요청 = new CreateSubjectRequest(
            "수학",
            MATH,
            ESSENTIAL,
            List.of("수학1", "수학2")
    );
}
