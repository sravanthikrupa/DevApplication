package com.app.dca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.modelmapper.ModelMapper;
@SpringBootApplication
@EnableSwagger2
public class DevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
    
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("Developer Community").description("contains api to manipulate Developer App")
				.version("myproductappV1.1").build();
	}
}
