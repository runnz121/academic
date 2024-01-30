package academic.main.user.domain.entity;

import academic.main.common.BaseUserInfo;
import academic.main.user.domain.AdminNumber;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("AD")
public class Administrator extends BaseUserInfo {

    @Embedded
    private AdminNumber adminNumber;
}
