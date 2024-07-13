package academic.main.classes.ui;

import academic.main.classes.application.command.SubjectService;
import academic.main.classes.ui.command.request.CreateSubjectRequest;
import academic.main.config.security.role.SecurityUserRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    // 과목 생성 (관리자만 생성 가능)
    @Secured(SecurityUserRoles.ROLE_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateSubjectRequest request) {
        subjectService.createSubject(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Secured(SecurityUserRoles.ROLE_ADMIN)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
}
