package academic.main.user.domain;

import academic.main.user.application.exception.InvalidatePhoneNumberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Column(name = "email")
    private String email;

    public static Email from(String inputEmail) {
        return new Email(inputEmail);
    }

    private Email(String inputEmail) {
        validate(inputEmail);
        this.email = inputEmail;
    }

    private static void validate(String inputEmail) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(inputEmail);

        if (!matcher.matches()) {
            throw new InvalidatePhoneNumberException(inputEmail);
        }
    }
}
