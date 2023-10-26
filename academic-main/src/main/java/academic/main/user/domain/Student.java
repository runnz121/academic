package academic.main.user.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("student")
public class Student extends BaseUserInfo {

    @Embedded
    private StudentNumber studentNumber;

}
