package academic.main.subject.command.application;

import academic.main.common.RequestUserInfo;
import academic.main.subject.infrastructure.dto.request.CreateSubjectRequest;
import academic.main.subject.infrastructure.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SubjectCreateService {

    private final SubjectRepository subjectRepository;
    private final RequestUserInfo requestUserInfo;

    public void createSubject(CreateSubjectRequest request) {

        log.info("request User : {}", requestUserInfo.getUserName());

        subjectRepository.save(request.toEntity());
    }
}
