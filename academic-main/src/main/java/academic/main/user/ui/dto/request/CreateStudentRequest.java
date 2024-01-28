package academic.main.user.ui.dto.request;

import academic.main.user.domain.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStudentRequest(

        @NotNull
        UserType userType,

        @NotBlank
        String id,

        @NotBlank
        String name,

        @NotNull
        String nickName,

        @NotBlank
        String phoneNumber,

        @NotBlank
        String email
) {
}
