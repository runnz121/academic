package academic.main.user.application.service.provider.impl;

import academic.main.user.application.service.provider.UserProvider;
import academic.main.user.domain.UserType;
import academic.main.user.domain.service.StudentService;
import academic.main.user.ui.dto.request.CreateStudentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StudentImpl implements UserProvider {

    private final StudentService studentService;

    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }

    @Override
    public void createUser(CreateStudentRequest request) {

//        Students createStudent = Students.toEntity(request);

//        studentService.createStudent(createStudent);

//        log.info("USER:STUDENT:CREATE 학생이 정상적으로 등록되었습니다. createStudent : {}", createStudent);
    }
}
