package academic.batch.config.database.rds.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class QuerydslConfiguration {

    @PersistenceContext(unitName = "primaryEntityManager")
    EntityManager primaryEntityManager;

    @PersistenceContext(unitName = "secondaryEntityManager")
    EntityManager secondaryEntityManager;

    @Primary
    @Bean(name = "primaryQueryFactory")
    public JPAQueryFactory primaryQueryFactory() {
        return new JPAQueryFactory(primaryEntityManager);
    }

    @Bean(name = "secondaryQueryFactory")
    public JPAQueryFactory secondaryQueryFactory() {
        return new JPAQueryFactory(secondaryEntityManager);
    }
}
