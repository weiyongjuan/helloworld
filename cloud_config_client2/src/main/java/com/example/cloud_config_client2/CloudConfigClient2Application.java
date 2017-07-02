package com.example.cloud_config_client2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@RestController
@EnableZuulProxy
public class CloudConfigClient2Application {
	
	@Value("${name}")
	private String name;
	
	@RequestMapping("/start2")
	public String hello() {
		return name+" hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClient2Application.class, args);
	}
}
