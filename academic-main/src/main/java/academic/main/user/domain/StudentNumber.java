package academic.main.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentNumber {

    @Column(name = "student_number")
    private String studentNumber;

    // TODO 학생 수 난수 생성 구현
}
