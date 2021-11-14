package com.springBootExamples;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticSearchExample {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchExample.class, args);
    }
}
