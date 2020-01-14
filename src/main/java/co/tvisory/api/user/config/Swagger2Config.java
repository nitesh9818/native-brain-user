package co.tvisory.api.user.config;

import org.springframework.beans.factory.annotation.Value;
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
public class Swagger2Config {
	
	@Value("${co.tvisory.api.base.package}")
	private String basePackage;
	
	@Value("${co.tvisory.title}")
	private String title;
	
	@Value("${co.tvisory.version}")
	private String version;
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
	            .apis(RequestHandlerSelectors
	                .basePackage(basePackage))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndPointsInfo());
	}
	
	
	@Bean
	public ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title(title)
	            .description("Employee Management REST API")
	            .contact(new Contact("Rahul Mishra", "www.TrueVisnory.com", "rahulsitm2@gmail.com"))
	            .version(version)
	            .build();
	}

}
