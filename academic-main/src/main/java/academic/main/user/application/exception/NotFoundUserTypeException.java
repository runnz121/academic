package academic.main.user.application.exception;

import academic.main.user.domain.UserType;

public class NotFoundUserTypeException extends IllegalArgumentException {

    private final UserType userType;

    public NotFoundUserTypeException(UserType userType, String message) {
        super(message);
        this.userType = userType;
    }
}
