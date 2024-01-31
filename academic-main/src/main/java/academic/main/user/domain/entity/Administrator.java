package academic.main.user.domain.entity;

import academic.main.common.BaseUserInfo;
import academic.main.user.domain.AdminNumber;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@DiscriminatorValue(value = "admin")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Administrator extends BaseUserInfo {

    @Embedded
    private AdminNumber adminNumber;
}
