package academic.main.classes.ui;

import academic.main.classes.application.command.SemesterService;
import academic.main.classes.ui.command.request.CreateSubjectRequest;
import academic.main.config.security.role.SecurityUserRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/semester")
@RequiredArgsConstructor
public class SemesterController {

    private final SemesterService semesterService;

    @Secured(SecurityUserRoles.ROLE_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateSubjectRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
