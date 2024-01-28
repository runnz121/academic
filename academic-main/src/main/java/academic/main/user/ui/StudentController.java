package academic.main.user.ui;

import academic.main.config.security.role.SecurityUserRoles;
import academic.main.user.application.service.UserCreateService;
import academic.main.user.ui.dto.request.CreateStudentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final UserCreateService userCreateService;

    @Secured(SecurityUserRoles.ROLE_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CreateStudentRequest request) {
        userCreateService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
