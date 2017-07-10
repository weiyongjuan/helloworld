package com.example.cloud_config_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@Configuration
public class CloudConfigClientApplication {
	@Value("${label}")
	private String label;
	@Autowired
//	private userServer sysUserServer;
	
	@RequestMapping("start1")
	public String hello() {
//		sysUser user = sysUserServer.findAll();
//		System.out.println(user.toString());
		return label+" hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}
}
