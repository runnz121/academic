package academic.main.user.domain.entity;

import academic.main.common.BaseUserInfo;
import academic.main.user.domain.StudentNumber;
import academic.main.user.ui.dto.request.CreateStudentRequest;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("student")
public class Student extends BaseUserInfo {

    // 학번
    @Embedded
    private StudentNumber studentNumber;


    // 이수 학기 수
//    @Embedded
//    private CompletedSemester

    // 과거 수강 내역


    public static Student toEntity(CreateStudentRequest request) {
        return Student.builder()
                .name(request.name())
                .build();
    }
}
