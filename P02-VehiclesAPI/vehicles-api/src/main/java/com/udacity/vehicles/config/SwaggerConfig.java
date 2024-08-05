package com.udacity.vehicles.config;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request. Please, follow the API documentation."),
        @ApiResponse(code = 401, message = "Unauthorized Access. Due to security constraints, your request cannot be authorized."),
        @ApiResponse(code = 500, message = "The server is down. Please make sure that the Vehicle API server is running.")
})
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Vehicles API API",
                "A REST API to maintain vehicle data and to provide a complete view of vehicle details including price and address.",
                "1.0",
                "http://www.udacity.com/vehicles",
                new Contact("Jumanazar Saidov", "www.jumanazar.uz", "jumanazarsaidov@gmail.com"),
                "License of API", "http://wwww.udacity.com/license", Collections.emptyList()
        );
    }
}
