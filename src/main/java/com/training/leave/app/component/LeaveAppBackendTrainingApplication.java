package com.training.leave.app.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.training.leave")
@EnableSwagger2
@EnableJpaRepositories("com.training.leave.app.dao")
@EntityScan("com.training.leave.app.entity")
@SpringBootApplication
public class LeaveAppBackendTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaveAppBackendTrainingApplication.class, args);
    }

//    @Override
//	public void addCorsMappings(CorsRegistry registry) {
//		
//		registry.addMapping("/**").allowedMethods(HttpMethod.OPTIONS.name(),
//                HttpMethod.PATCH.name(),
//                HttpMethod.PUT.name(),
//                HttpMethod.DELETE.name(),
//                HttpMethod.GET.name(),
//                HttpMethod.POST.name())
//        .maxAge(3600);
//	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}
