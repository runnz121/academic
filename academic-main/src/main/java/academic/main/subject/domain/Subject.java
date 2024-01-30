package academic.main.subject.domain;

import academic.main.common.Audit;
import academic.main.subject.common.SubjectCode;
import academic.main.subject.common.SubjectType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class Subject extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SubjectType type;

    @Column(name = "code")
    @Enumerated(EnumType.STRING)
    private SubjectCode code;

    public Subject() {
        super();
    }

    public static Subject of(String name,
                             SubjectCode code,
                             SubjectType type
    ) {
        return Subject.builder()
                .name(name)
                .type(type)
                .code(code)
                .build();
    }
}
