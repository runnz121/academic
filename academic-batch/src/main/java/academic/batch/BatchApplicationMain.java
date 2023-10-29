package academic.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableBatchProcessing
@SpringBootApplication
public class BatchApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(BatchApplicationMain.class, args);
    }
}