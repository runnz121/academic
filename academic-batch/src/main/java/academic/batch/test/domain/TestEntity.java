package academic.batch.test.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test_entity")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String value;

    @Builder
    public TestEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
