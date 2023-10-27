package academic.main.aws;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecretManagerTest {

    private static final String LOCAL_DB_URL = "jdbc:mysql://localhost:3306/academic";

    @Value("${db.url}")
    String dbUrl;

    @Test
    @DisplayName("secrets manager 로 부터 로컬 db url 을 갖고온다.")
    void secretMangerTest() {

        assertThat(dbUrl).isEqualTo(LOCAL_DB_URL);
    }
}
