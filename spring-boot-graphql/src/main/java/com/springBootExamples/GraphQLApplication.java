package com.springBootExamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * {@link org.springframework.data.web.querydsl.QuerydslPredicateArgumentResolver} -> get türü istekler
 * {@link com.coxautodev.graphql.tools.GraphQLMutationResolver} -> sunucudaki verileri değiştirmek üzere apilerin türetildiği sınıf
 */
@SpringBootApplication
public class GraphQLApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GraphQLApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
