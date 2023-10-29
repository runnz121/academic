package academic.batch._test.repository.primary;

import academic.batch._test.domain.TestEntity;
import academic.batch.config.database.rds.querydsl.PrimaryQuerydslRepositorySupport;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Qualifier;

public class TestRepositoryCustomImpl extends PrimaryQuerydslRepositorySupport implements TestRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public TestRepositoryCustomImpl(@Qualifier("primaryQueryFactory") JPAQueryFactory primaryQueryFactory)  {
        super(TestEntity.class);
        this.jpaQueryFactory = primaryQueryFactory;
    }
}
