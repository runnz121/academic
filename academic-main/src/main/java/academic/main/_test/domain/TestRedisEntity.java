package academic.main._test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor
@RedisHash("test")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestRedisEntity {

    @Id
    private String id;

    private String name;

    private String value;

    private String value2;

    @Builder
    public TestRedisEntity(String id, String name, String value, String value2) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.value2 = value2;
    }

    public void updateValue2(String value2) {
        this.value2 = value2;
    }
}
