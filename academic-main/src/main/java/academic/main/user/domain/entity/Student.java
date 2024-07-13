package academic.main.user.domain.entity;

import academic.main.user.domain.*;
import academic.main.user.ui.command.request.CreateStudentRequest;
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

    public static Student toEntity(CreateStudentRequest request) {
        return Student.builder()
                .name(request.name())
                .studentNumber(StudentNumber.from(request.id()))
                .phone(Phone.from(request.phoneNumber()))
                .email(Email.from(request.email()))
                .birth(Birth.from(request.birth()))
                .userType(UserType.STUDENT)
                .build();
    }
}
