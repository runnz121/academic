package academic.main.classes.application.command;

import academic.main.classes.domain.entity.Lecture;
import academic.main.classes.domain.entity.Subject;
import academic.main.classes.infrastructure.persistence.repository.LectureRepository;
import academic.main.classes.infrastructure.persistence.repository.SubjectRepository;
import academic.main.classes.ui.command.request.CreateSubjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public void createSubject(CreateSubjectRequest request) {

        Subject subject = request.toEntity();

        List<Lecture> lectureList = request.lectureNames().stream()
                .map(lectureName -> {
                    Lecture lecture = Lecture.of(lectureName);
                    lecture.updateSubject(subject);
                    return lecture;
                })
                .toList();

        subject.addLectureList(lectureList);

        // 1. 과목 저장
        subjectRepository.save(subject);
        // 2. 강의 저장
//        lectureRepository.saveAll(lectureList);
    }

    @Transactional
    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
