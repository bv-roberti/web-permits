package web.portal.permits.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;
import web.portal.permits.errors.ExceptionAdvice;

@Configuration
public class Configurations {

    @Bean
    public ExceptionAdvice controllerAdvice() {
        return new ExceptionAdvice();
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModules(
                new ProblemModule(),
                new ConstraintViolationProblemModule());
    }

}
