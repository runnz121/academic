package academic.main.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminNumber {

    @Column(name = "admin_number")
    private String adminNumber;

    // TODO 관리자 난수 생성 구현
}
