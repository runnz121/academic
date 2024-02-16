package academic.main.classes.domain.entity;

import academic.main.common.Audit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@SuperBuilder
@Table(name = "lecture")
@EntityListeners(AuditingEntityListener.class)
public class Lecture extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Lecture() {
        super();
    }

    public void updateSubject(Subject subject) {
        this.subject = subject;
        if (!subject.getLectureList().contains(this)) {
            subject.getLectureList().add(this);
        }
    }

    public static Lecture of(String name) {
        return Lecture.builder()
                .name(name)
                .build();
    }
}
