package com.gamgyuls.gamgyuls.config;  // 패키지 경로에 맞게 수정하세요

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration    // 스프링 실행 시 설정 파일로 읽어드리기 위한 어노테이션
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Gamgyuls Swagger")  // 프로젝트명에 맞게 수정하세요
                .description("Gamgyuls 프로젝트의 REST API 문서")
                .version("1.0.0");
    }
}