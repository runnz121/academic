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
public class Phone {

    private static final String PHONE_REGEX = "^(\\d{3}-\\d{4}-\\d{4})$";

    @Column(name = "phone_number")
    private String phoneNumber;

    public static Phone from(String inputPhoneNumber) {
        return new Phone(inputPhoneNumber);
    }

    private Phone(String inputPhoneNumber) {

        validate(inputPhoneNumber);

        this.phoneNumber = inputPhoneNumber;
    }

    private static void validate(String inputPhoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(inputPhoneNumber);

        if (!matcher.matches()) {
            throw new InvalidatePhoneNumberException(inputPhoneNumber);
        }
    }
}
