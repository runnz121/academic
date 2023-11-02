package academic.main.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUserInfo {

    private String userId;

    private String userName;

    @Builder
    public RequestUserInfo(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static RequestUserInfo of(String userName) {

        return RequestUserInfo.builder()
                .userName(userName)
                .build();
    }

}
