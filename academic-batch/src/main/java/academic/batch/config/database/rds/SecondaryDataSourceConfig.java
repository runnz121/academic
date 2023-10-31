package academic.batch.config.database.rds;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "secondaryEntityManagerFactory",
//        transactionManagerRef = "secondaryTransactionManager",
//        basePackages = "academic.batch.test.repository.secondary"
//        ,
//        basePackages = DBConstants.PACKAGE, includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Secondary.class)
//        }
//)
public class SecondaryDataSourceConfig {

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean readEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("secondaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("academic.batch.test.domain") // Replace with your package name
                .persistenceUnit("secondaryEntityManager")
                .build();
    }


//    @Bean
//    @ConfigurationProperties("secondary.datasource")
//    public DataSourceProperties secondaryDatasourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "secondaryDataSource")
//    @ConfigurationProperties("secondary.datasource.configuration")
//    public DataSource secondaryDataSource() {
//        return secondaryDatasourceProperties()
//                .initializeDataSourceBuilder()
//                .type(HikariDataSource.class)
//                .build();
//    }
//
//    @Bean(name = "secondaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        DataSource dataSource = secondaryDataSource();
//        return builder
//                .dataSource(dataSource)
//                .packages("academic.batch.test.domain")
//                .persistenceUnit("secondaryEntityManager")
//                .build();
//    }
//
//    @Bean(name = "secondaryTransactionManager")
//    public PlatformTransactionManager secondaryTransactionManager(
//            @Qualifier("secondaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
//    ) {
//        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
//    }
}
