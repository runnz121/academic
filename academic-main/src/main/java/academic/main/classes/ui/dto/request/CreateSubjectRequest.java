package academic.main.classes.ui.dto.request;

import academic.main.classes.domain.entity.Subject;
import academic.main.classes.domain.SubjectCode;
import academic.main.classes.domain.SubjectType;

import java.util.List;

public record CreateSubjectRequest(
        String name,
        SubjectCode code,
        SubjectType type,
        // 강의 이름
        List<String> lectureNames
) {
    public Subject toEntity() {

        return Subject.of(
                this.name,
                this.code,
                this.type
        );
    }
}
