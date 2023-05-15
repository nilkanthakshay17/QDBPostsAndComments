package com.qdb.app.postsandcomments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class QdbPostsAndCommentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QdbPostsAndCommentsApplication.class, args);
		System.out.println("QDB Posts and Comments Service Started");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
