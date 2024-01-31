package academic.main.user.domain.entity;

import academic.main.common.BaseUserInfo;
import academic.main.user.domain.StudentNumber;
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
@DiscriminatorValue(value = "students")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student extends BaseUserInfo {

    // 학번
    @Embedded
    private StudentNumber studentNumber;


    // 이수 학기 수
//    @Embedded
//    private CompletedSemester

    // 과거 수강 내역

//    public static Students toEntity(CreateStudentRequest request) {
//        return Students.builder()
//                .name(request.name())
//                .studentNumber(StudentNumber.from(request.id()))
//                .phone(Phone.from(request.phoneNumber()))
//                .build();
//    }
}
