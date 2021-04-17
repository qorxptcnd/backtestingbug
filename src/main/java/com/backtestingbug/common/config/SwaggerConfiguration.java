package com.backtestingbug.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : Swagger 설정
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerAPI() {

        //Access Token 헤더 추가
        List<Parameter> global = new ArrayList<>();
        global.add(new ParameterBuilder()
                .name("Authorization")
                .description("Access Token")
                .parameterType("header")
                .required(false)
                .modelRef(new ModelRef("string"))
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(global)
                .apiInfo(this.swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.any()) // 대상 : 모든 컨트롤러 패키지
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true); // 기본 메시지(EX. 404)

    }

    private ApiInfo swaggerInfo() {

        return new ApiInfoBuilder()
                .title("backtestingbug API Documentation")
                .description("백텟충 API")
                .version("1.0.0")
                .build();

    }

}
