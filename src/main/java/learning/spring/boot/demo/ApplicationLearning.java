package learning.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling // using for scheduling and using bY @scheduled in controller
//@EnableEurekaClient // enable eureka client
/*@EnableAdminServer*/
/*@EnableDiscoveryClient*/
public class ApplicationLearning {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationLearning.class);

    public static void main(String[] args) {
        logger.info("this is a info message ");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        SpringApplication.run(ApplicationLearning.class, args);
    }
}
