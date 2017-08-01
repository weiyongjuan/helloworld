package com.example.cloud_config_client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_config_client.entity.sysUser;
import com.example.cloud_config_client.server.UserServer;



@SpringBootApplication
@RestController
public class CloudConfigClientApplication {
	
	private Logger logger = LoggerFactory.getLogger(Logger.class);
	
	@Value("${label}")
	private String label;
	@Autowired
	private UserServer userServer;
	
	@RequestMapping("start1")
	public String hello() {
		List<sysUser> list = userServer.findAll();
	
		if(list != null && list.size()>0){
			for(sysUser user:list){
				logger.info("-------------------------dfdf-------------------------------");
				System.out.println(user.toString());
			}
		}
		
		return label+" hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}
}
