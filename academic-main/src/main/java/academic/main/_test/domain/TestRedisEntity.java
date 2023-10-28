package academic.main._test.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("test")
public class TestRedisEntity {

    @Id
    private String id;

    private String name;

    private String value;

    @Builder
    public TestRedisEntity(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
