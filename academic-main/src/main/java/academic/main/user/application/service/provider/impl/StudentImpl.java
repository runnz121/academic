package academic.main.user.application.service.provider.impl;

import academic.main.user.application.service.provider.UserProvider;
import academic.main.user.domain.UserType;
import academic.main.user.domain.entity.Student;
import academic.main.user.domain.service.StudentService;
import academic.main.user.ui.dto.request.CreateStudentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentImpl implements UserProvider {

    private final StudentService studentService;

    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }

    @Override
    public void createUser(CreateStudentRequest request) {

        Student createStudent = Student.toEntity();

        studentService.createStudent();
    }
}
