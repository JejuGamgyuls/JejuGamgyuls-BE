package com.gamgyuls.gamgyuls.config;  // 패키지 경로에 맞게 수정하세요

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;  // Info를 io.swagger.v3.oas.models.info에서 가져옵니다
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        security = @SecurityRequirement(name = "bearerAuth") // 보안 요구 사항
)
@SecurityScheme(
        name = "bearerAuth", // 보안 스키마 이름
        type = SecuritySchemeType.HTTP, // 보안 타입
        scheme = "bearer", // 스킴
        bearerFormat = "JWT" // Bearer 토큰 포맷
)
@Configuration // 스프링이 이 클래스를 설정으로 인식하게 함
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()) // Components 빈 설정
                .info(apiInfo()); // API 정보 설정
    }

    private Info apiInfo() {
        return new Info()
                .title("Gamgyuls Swagger") // API 제목
                .description("Gamgyuls 프로젝트의 REST API 문서") // API 설명
                .version("1.0.0"); // API 버전
    }
}