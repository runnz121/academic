package academic.main.admin.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {

    // 과목 생성
    @PostMapping
    public ResponseEntity createSubject() {

    }

    // 학생 생성
    @PostMapping
    public ResponseEntity createStudent() {

    }

    // 학기 생성
    @PostMapping
    public ResponseEntity createSemester() {

    }

    // 강의 등록 (학기가 존재해야됨)
    @PostMapping
    public ResponseEntity createLecture() {

    }

    // 학기 확정
    @PostMapping
    public ResponseEntity confirmSemester() {

    }

    // 수강신청 시작(확정된 학기에 대해)
    @PostMapping
    public ResponseEntity initEnrolment() {

    }

    // 수강신청 종료
    @PostMapping
    public ResponseEntity closeEnrolment() {

    }
}
