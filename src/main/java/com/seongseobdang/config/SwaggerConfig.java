package com.seongseobdang.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration//@EnableWebMvc -> springdoc 2.3.0버전일 때 활성화
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI() {

		Info info = new Info()
				.title("SSD \n SeongSeobDang ")
				.version("v1.0.0") //처음에 0.0.1이었음 (딱히상관없을듯)
				.description("~FIND YOUR HIKING PLACE~");

		return new OpenAPI()
				.components(new Components())
				.info(info);
	}

}