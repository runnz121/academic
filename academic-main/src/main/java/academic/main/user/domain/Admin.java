package academic.main.user.domain;

import academic.main.common.BaseUserInfo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("admin")
public class Admin extends BaseUserInfo {

    @Embedded
    private AdminNumber adminNumber;
}
