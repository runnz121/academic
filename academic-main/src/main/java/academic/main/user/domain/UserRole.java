package academic.main.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    ADMIN("1000"),
    STUDENT("2000")
    ;

    private final String code;
}
