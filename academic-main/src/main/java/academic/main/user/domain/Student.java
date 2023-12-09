package academic.main.user.domain;

import academic.main.common.BaseUserInfo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("student")
public class Student extends BaseUserInfo {

    // 학번
    @Embedded
    private StudentNumber studentNumber;

    // 이수 학기 수
//    @Embedded
//    private CompletedSemester

    // 과거 수강 내역

}
