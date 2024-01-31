package academic.main.user.domain.service;

import academic.main.user.domain.entity.Student;
import academic.main.user.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void createStudent(Student registerStudent) {
        studentRepository.save(registerStudent);
    }
}
