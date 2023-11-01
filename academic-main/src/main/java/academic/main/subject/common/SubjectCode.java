package academic.main.subject.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum SubjectCode {

    UNDEFINED("0000"),
    MATH("0001"),
    KOREAN("0002"),
    ;

    private final String number;

    public static SubjectCode toECode(String number) {

        if ( ! StringUtils.hasText(number)) {
            return UNDEFINED;
        }

        return Arrays.stream(values())
                .filter(code -> code.getNumber().equals(number))
                .findFirst()
                .orElse(UNDEFINED);
    }
}
