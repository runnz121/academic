package academic.main.config.security.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SecurityUserRoles {

    STUDENT("STUDENT","학생"),
    TEACHER("TEACHER", "선생님"),
    ADMIN("ADMIN", "관리자")
    ;

    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    private final String code;
    private final String desc;
}
