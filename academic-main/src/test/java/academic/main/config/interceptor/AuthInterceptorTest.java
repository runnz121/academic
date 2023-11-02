package academic.main.config.interceptor;

import academic.main.support.SpringBootTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;

@DisplayName("인증 인터셉터 테스트")
class AuthInterceptorTest extends SpringBootTestSupport {

    @Autowired
    WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToWebHandler(exchange -> {
            String path = exchange.getRequest().getURI().getPath();

            if ("/v1/subject".equals(path)) {

                exchange.getRequest().getHeaders().put("name", Arrays.asList("jongbin"));

                return exchange.getSession()
                        .doOnNext(webSession -> webSession.getAttributes().put("name", "jongbin"))
                        .then();
            }
            // 추가 분기
            return null;
        }).build();
    }

    @Test
    @DisplayName("인터셉터에 요청 유저 정보가 실리는지 확인하는 테스트")
    void getRequestUserInfo() {

        webTestClient.get().uri("/v1/subject")
                .exchange()
                .expectHeader()
                .valueMatches("name", "jongbin")
                .expectStatus()
                .isCreated();
    }
}