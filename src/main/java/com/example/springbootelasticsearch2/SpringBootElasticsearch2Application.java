package com.example.springbootelasticsearch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@SpringBootApplication
@EnableElasticsearchRepositories
public class SpringBootElasticsearch2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticsearch2Application.class, args);
	}
}
