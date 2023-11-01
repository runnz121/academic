package academic.main.common;

import academic.main.user.domain.Birth;
import academic.main.user.domain.Email;
import academic.main.user.domain.Phone;
import academic.main.user.domain.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "user")
public abstract class BaseUserInfo extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    protected Long id;

    @Column(name = "name")
    protected String name;

    @Embedded
    protected Phone phone;

    @Embedded
    protected Email email;

    @Embedded
    protected Birth birth;

    protected UserRole userRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        BaseUserInfo baseUserInfo = (BaseUserInfo) o;
        return Objects.equals(id, baseUserInfo.id);
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
