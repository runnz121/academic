package academic.main.subject.ui;

import academic.main.subject.command.application.SubjectCreateService;
import academic.main.support.TestSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static academic.main.fixture.subject.SubjectFixture.과목_생성_요청;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SubjectController.class)
@WithMockUser
@DisplayName("과목 컨트롤러 테스트")
class SubjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SubjectCreateService subjectCreateService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("과목 생성 요청 테스트")
    void createSubjectPost() throws Exception {

        willDoNothing().given(subjectCreateService).createSubject(any());

        mockMvc.perform(
                post("/v1/subject")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestSupport.toJsonString(과목_생성_요청)))
                .andExpect(status().isCreated());
    }

}