package academic.main.subject.dto.request;

import academic.main.subject.common.SubjectCode;
import academic.main.subject.common.SubjectType;
import academic.main.subject.domain.Subject;

public record CreateSubjectRequest(
        String name,
        SubjectCode code,
        SubjectType type
) {
    public Subject toEntity() {

        return Subject.of(
                this.name,
                this.code,
                this.type
        );
    }
}
