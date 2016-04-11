package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringhelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhelloworldApplication.class, args);
	}
}
