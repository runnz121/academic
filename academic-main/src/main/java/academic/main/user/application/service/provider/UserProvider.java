package academic.main.user.application.service.provider;

import academic.main.user.domain.UserType;
import academic.main.user.ui.dto.request.CreateStudentRequest;

public interface UserProvider {

    UserType getUserType();

    void createUser(CreateStudentRequest request);
}
