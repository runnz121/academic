package academic.main.fixture.subject;

import academic.main.subject.dto.request.CreateSubjectRequest;

import static academic.main.subject.common.SubjectCode.MATH;
import static academic.main.subject.common.SubjectType.ESSENTIAL;

public class SubjectFixture {

    public static CreateSubjectRequest 과목_생성_요청 = new CreateSubjectRequest(
            "수학",
            MATH,
            ESSENTIAL
    );
}
