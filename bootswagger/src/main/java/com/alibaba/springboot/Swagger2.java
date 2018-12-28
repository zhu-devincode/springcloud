package com.alibaba.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration	//Spring启动加载该类配置
@EnableSwagger2	//启动Swagger
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())	//创建API信息
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.alibaba.springboot.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("Springboot通过swagger构建API文档")
				.description("需要了解更多关注http://www.spring.io.swagger")
				.termsOfServiceUrl("http://www.spring.io.swagger")
				.contact("sunf")
				.version("1.0")
				.build();
	}

}
