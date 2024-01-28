package academic.main.user.application.service.provider;

import academic.main.user.application.exception.NotFoundUserTypeException;
import academic.main.user.domain.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserProviderManager {

    private final Set<UserProvider> userProviders;

    public UserProvider getProvider(UserType userType) {
        return userProviders
                .stream()
                .filter(provider -> userType == provider.getUserType())
                .findFirst()
                .orElseThrow(() -> new NotFoundUserTypeException(userType, "해당 유저 타입을 찾을 수 없습니다."));
    }
}
