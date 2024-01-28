package academic.main.user.application.service;

import academic.main.user.application.service.provider.UserProviderManager;
import academic.main.user.ui.dto.request.CreateStudentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserCreateService {

    private final UserProviderManager userProviderManager;

    public void createUser(CreateStudentRequest request) {
        userProviderManager
                .getProvider(request.userType())
                .createUser(request);
    }
}
