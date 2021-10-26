package com.weCode.bookStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket bookStoreApiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.weCode.bookStore.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(apiMetadata());
    }

    private ApiInfo apiMetadata() {
        return new ApiInfo(
                "Book Store Rest Api",
                "All apis for book store aplication",
                "1.0",
                "www.algorhym.tech",
                new Contact(
                        "Book store admin",
                        "https://algo-book-store.herokuapp.com/",
                        "bookStore@gmail.com"
                ),
                "book store license",
                "license url",
                Collections.emptyList()

                );
    }
}
