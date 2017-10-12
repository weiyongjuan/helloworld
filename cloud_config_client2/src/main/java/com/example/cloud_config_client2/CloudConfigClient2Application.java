package com.example.cloud_config_client2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 将excel转换成json
 * http://blog.csdn.net/allen202/article/details/54145479
 * @author Dell
 *
 */
@SpringBootApplication
@Configuration
@RestController
public class CloudConfigClient2Application {
	
	@Value("${label}")
	private String name;
	
	@RequestMapping("/start2")
	public String hello() {
		return name+" hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClient2Application.class, args);
	}
}
