package academic.batch.config.database.rds.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerydslConfiguration {

    @PersistenceContext(unitName = "primaryEntityManager")
    EntityManager entityManager1;

    @PersistenceContext(unitName = "secondaryEntityManager")
    EntityManager entityManager2;

    @Bean(name = "primaryQueryFactory")
    public JPAQueryFactory primaryQueryFactory() {
        return new JPAQueryFactory(entityManager1);
    }

    @Bean(name = "secondaryQueryFactory")
    public JPAQueryFactory secondaryQueryFactory() {
        return new JPAQueryFactory(entityManager2);
    }
}
