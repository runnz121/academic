package academic.batch.test.repository.primary;

import academic.batch.config.database.rds.querydsl.PrimaryQuerydslRepositorySupport;
import academic.batch.test.domain.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static academic.batch.test.domain.QTestEntity.testEntity;

@Repository
public class PrimaryTestRepositoryCustomImpl extends PrimaryQuerydslRepositorySupport implements PrimaryTestRepositoryCustom {

    private final JPAQueryFactory primaryQueryFactory;

    public PrimaryTestRepositoryCustomImpl(JPAQueryFactory primaryQueryFactory) {
        super(TestEntity.class);
        this.primaryQueryFactory = primaryQueryFactory;
    }


    @Override
    public List<TestEntity> findAlltestEntityList() {

        return primaryQueryFactory
                .selectFrom(testEntity)
                .fetch();
    }
}
