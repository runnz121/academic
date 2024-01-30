package academic.main.user.domain.entity;

import academic.main.common.BaseUserInfo;
import academic.main.user.domain.Phone;
import academic.main.user.domain.StudentNumber;
import academic.main.user.ui.dto.request.CreateStudentRequest;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("ST")
public class Students extends BaseUserInfo {

    // 학번
    @Embedded
    private StudentNumber studentNumber;


    // 이수 학기 수
//    @Embedded
//    private CompletedSemester

    // 과거 수강 내역

    public static Students toEntity(CreateStudentRequest request) {
        return Students.builder()
                .name(request.name())
                .studentNumber(StudentNumber.from(request.id()))
                .phone(Phone.from(request.phoneNumber()))
                .build();
    }
}
