package academic.batch.test.job;

import academic.batch.test.repository.secondary.SecondaryTestRepository;
import academic.batch.test.repository.secondary.SecondaryTestRepositoryCustomImpl;
import academic.batch.test.tasklet.TestTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TestJobConfiguration {

    private final SecondaryTestRepository secondaryTestRepository;
    private final SecondaryTestRepositoryCustomImpl secondaryTestRepositoryCustomImpl;

    @Bean
    public Job testJob(Step testStep, JobRepository jobRepository) {
        return new JobBuilder("testJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(testStep)
                .build();
    }

    @Bean
    public Step testStep(PlatformTransactionManager platformTransactionManager, JobRepository jobRepository) {

        return new StepBuilder("testStep", jobRepository)
                .tasklet(new TestTasklet(
                        secondaryTestRepository,
                        secondaryTestRepositoryCustomImpl),
                        platformTransactionManager
                )
                .build();
    }
}
