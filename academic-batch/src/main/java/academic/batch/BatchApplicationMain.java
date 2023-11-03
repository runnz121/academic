package academic.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class BatchApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(BatchApplicationMain.class, args);
    }
}