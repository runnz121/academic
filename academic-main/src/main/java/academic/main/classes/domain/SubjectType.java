package academic.main.classes.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SubjectType {

    ESSENTIAL("001", "필수"),
    OPTION("002", "선택"),
    ;

    private final String code;
    private final String desc;
}
