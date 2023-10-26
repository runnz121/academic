package academic.main.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "user")
public abstract class BaseUserInfo {

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

    @CreatedDate
    @Column(name = "created_at")
    protected LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

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
