package learning.spring.boot.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@SpringBootApplication
@EnableScheduling // using for scheduling and using bY @scheduled in controller
//@EnableEurekaClient // enable eureka client
@EnableAdminServer
public class ApplicationLearning {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationLearning.class);

    public static void main(String[] args) {
        logger.info("this is a info message ");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        SpringApplication.run(ApplicationLearning.class, args);
    }

    /*
     *  check cors for each path pattern
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/product").allowedOrigins("http://localhost:8888");
                registry.addMapping("/file").allowedOrigins("http://localhost:8888");
            }
        };
    }
}
