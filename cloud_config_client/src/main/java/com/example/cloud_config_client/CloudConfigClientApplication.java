package com.example.cloud_config_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_config_client.entity.sysUser;
import com.example.cloud_config_client.server.userServer;

@SpringBootApplication
@RestController
@Configuration
public class CloudConfigClientApplication {
	@Value("${name}")
	private String name;
	@Autowired
	private userServer sysUserServer;
	
	@RequestMapping("start1")
	public String hello() {
		sysUser user = sysUserServer.findAll();
		System.out.println(user.toString());
		return name+" hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}
}
