package academic.main.classes.domain.entity;

import academic.main.common.Audit;
import academic.main.classes.domain.SubjectCode;
import academic.main.classes.domain.SubjectType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@Table(name = "subject")
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

    @Builder.Default
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectureList = new ArrayList<>();

    public Subject() {
        super();
    }

    public void addLecture(Lecture lecture) {
        this.lectureList.add(lecture);
        if (lecture.getSubject() != this) {
            lecture.updateSubject(this);
        }
    }

    public void addLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public static Subject of(String name,
                             SubjectCode code,
                             SubjectType type) {
        return Subject.builder()
                .name(name)
                .type(type)
                .code(code)
                .build();
    }
}
