package academic.batch.test.repository.secondary;

import academic.batch.config.database.rds.querydsl.SecondaryQuerydslRepositorySupport;
import academic.batch.test.domain.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static academic.batch.test.domain.QTestEntity.testEntity;

@Repository
public class SecondaryTestRepositoryCustomImpl extends SecondaryQuerydslRepositorySupport implements SecondaryTestRepositoryCustom {

    private final JPAQueryFactory secondaryQueryFactory;

    public SecondaryTestRepositoryCustomImpl(JPAQueryFactory secondaryQueryFactory) {
        super(TestEntity.class);
        this.secondaryQueryFactory = secondaryQueryFactory;
    }

    @Override
    public List<TestEntity> findAlltestEntityList() {

        return secondaryQueryFactory
                .selectFrom(testEntity)
                .fetch();
    }
}
