package com.inpixon.candidate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.inpixon.candidate"))
                .paths(PathSelectors.any())
                .build();
    }
	@SuppressWarnings("unused")
	private ApiInfo getApiInfo() {
	        Contact contact = new Contact("Meeta Rout", "i dont have a blog", "routmeeta1991@gmail.com");
	        return new ApiInfoBuilder()
	                .title("candidate Service")
	                .description("This is a candidate Service")
	                .version("1.0.0")
	                .license("Candidate 2.0")
	                .contact(contact)
	                .build();
	}
}
