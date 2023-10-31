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
import org.springframework.context.annotation.Primary;
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
//        entityManagerFactoryRef = "primaryEntityManagerFactory",
//        transactionManagerRef = "primaryTransactionManager",
//        basePackages = {"academic.batch.test.repository.primary"}
//        ,
//        basePackages = DBConstants.PACKAGE, includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Primary.class)
//        }
//)
public class PrimaryDataSourceConfig {

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean readEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("primaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("academic.batch.test.domain") // Replace with your package name
                .persistenceUnit("primaryEntityManager")
                .build();
    }


//
//    @Primary
//    @Bean
//    @ConfigurationProperties("primary.datasource")
//    public DataSourceProperties primaryDatasourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @Primary
//    @ConfigurationProperties("primary.datasource.configuration")
//    public DataSource primaryDataSource() {
//        return primaryDatasourceProperties()
//                .initializeDataSourceBuilder()
//                .type(HikariDataSource.class)
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "primaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        DataSource dataSource = primaryDataSource();
//        return builder
//                .dataSource(dataSource)
//                .packages("academic.batch.test.domain")
//                .persistenceUnit("primaryEntityManager")
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "primaryTransactionManager")
//    public PlatformTransactionManager primaryTransactionManager(
//            final @Qualifier("primaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
//    ) {
//        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
//    }
}
