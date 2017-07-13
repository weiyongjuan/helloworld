package com.example.cloud_config_client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_config_client.entity.sysUser;
import com.example.cloud_config_client.server.userServer;



@SpringBootApplication
@RestController
@Configuration
@ComponentScan(basePackages="com.example.cloud_config_client")
public class CloudConfigClientApplication {
	@Value("${label}")
	private String label;
	@Autowired
	private userServer sysUserServer;
	
	@RequestMapping("start1")
	public String hello() {
		List<sysUser> list = sysUserServer.findAll();
		if(list != null && list.size()>0){
			for(sysUser user:list){
				System.out.println(user.toString());
			}
		}
		
		return label+" hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}
}
