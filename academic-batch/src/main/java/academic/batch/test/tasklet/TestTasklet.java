package academic.batch.test.tasklet;

import academic.batch.test.domain.TestEntity;
import academic.batch.test.repository.secondary.SecondaryTestRepository;
import academic.batch.test.repository.secondary.SecondaryTestRepositoryCustomImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;

@RequiredArgsConstructor
public class TestTasklet implements Tasklet {

    private final SecondaryTestRepository secondaryTestRepository;
    private final SecondaryTestRepositoryCustomImpl secondaryTestRepositoryCustomImpl;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.out.println("TestTasklet start >>>>>>");

        List<TestEntity> testEntityList = secondaryTestRepositoryCustomImpl.findAlltestEntityList();

//        List<TestEntity> testEntityList = secondaryTestRepository.findAll();

        testEntityList.forEach(
                System.out::println
        );

        System.out.println("TestTasklet end >>>>>>");

        return RepeatStatus.FINISHED;
    }
}
