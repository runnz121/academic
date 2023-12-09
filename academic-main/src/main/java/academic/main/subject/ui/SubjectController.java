package academic.main.subject.ui;

import academic.main.subject.command.application.SubjectCreateService;
import academic.main.subject.dto.request.CreateSubjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectCreateService subjectCreateService;

    // 과목 생성
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSubjectRequest request) {

        subjectCreateService.createSubject(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
