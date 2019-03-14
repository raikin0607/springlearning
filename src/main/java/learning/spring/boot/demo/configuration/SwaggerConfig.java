package learning.spring.boot.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*
    * Create bean for using swagger
    * https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
    */
    @Bean
    public Docket learningApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("learning.spring.boot.demo.controller"))
                .build();
    }
}
