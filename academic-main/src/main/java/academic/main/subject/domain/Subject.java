package academic.main.subject.domain;

import academic.main.common.Audit;
import academic.main.subject.common.SubjectCode;
import academic.main.subject.common.SubjectType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    public Subject(String name, SubjectType type, SubjectCode code) {
        this.name = name;
        this.type = type;
        this.code = code;
    }

    public static Subject of(String name,
                             SubjectType type,
                             SubjectCode code) {

        return Subject.builder()
                .name(name)
                .type(type)
                .code(code)
                .build();
    }
}
