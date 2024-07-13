package academic.main.classes.domain.entity;

import academic.main.common.Audit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@SuperBuilder
@Table(name = "semester")
@EntityListeners(AuditingEntityListener.class)
public class Semester extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private Long id;

    @Column(name = "name")
    private String semesterName;

    @Column
    private

    public Semester() {

    }
}
