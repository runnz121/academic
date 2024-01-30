package academic.main.user.domain;

import academic.main.common.DateUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentNumber {

    @Column(name = "student_number")
    private String studentNumber;

    public static StudentNumber from(String id) {
        return new StudentNumber(id);
    }

    private StudentNumber(String id) {
        this.studentNumber = createStudentNumber(id);
    }

    public String createStudentNumber(String id) {
        return "%s%s".formatted(DateUtils.toString(LocalDateTime.now(), DateUtils.YYYYMMDD), id);
    }
}
