package academic.main.user.domain.entity;

import academic.main.common.Audit;
import academic.main.user.domain.Birth;
import academic.main.user.domain.Email;
import academic.main.user.domain.Phone;
import academic.main.user.domain.UserType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@SuperBuilder
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public abstract class BaseUserInfo extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_key")
    protected Long key;

    @Column(name = "name")
    protected String name;

    @Embedded
    protected Phone phone;

    @Embedded
    protected Email email;

    @Embedded
    protected Birth birth;

    @Enumerated(EnumType.STRING)
    protected UserType userType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        BaseUserInfo baseUserInfo = (BaseUserInfo) o;
        return Objects.equals(key, baseUserInfo.key);
    }

    @Override
    public int hashCode() {
        return key.intValue();
    }
}
