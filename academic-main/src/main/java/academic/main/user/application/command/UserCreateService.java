package academic.main.user.application.command;

import academic.main.user.domain.entity.Student;
import academic.main.user.domain.service.StudentService;
import academic.main.user.ui.command.request.CreateStudentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final StudentService studentService;

    @Transactional
    public void createUser(CreateStudentRequest request) {
        Student createStudent = Student.toEntity(request);
        studentService.createStudent(createStudent);
    }
}
