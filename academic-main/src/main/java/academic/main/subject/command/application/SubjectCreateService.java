package academic.main.subject.command.application;

import academic.main.subject.dto.request.CreateSubjectRequest;
import academic.main.subject.infrastructure.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubjectCreateService {

    private final SubjectRepository subjectRepository;

    @Transactional
    public void createSubject(CreateSubjectRequest request) {

        subjectRepository.save(request.toEntity());
    }
}
