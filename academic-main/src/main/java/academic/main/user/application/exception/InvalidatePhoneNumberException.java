package academic.main.user.application.exception;

public class InvalidatePhoneNumberException extends IllegalArgumentException {

    private final String phoneNumber;

    public InvalidatePhoneNumberException(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
