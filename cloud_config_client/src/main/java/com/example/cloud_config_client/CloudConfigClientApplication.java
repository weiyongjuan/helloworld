package com.example.cloud_config_client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_config_client.entity.AuditOrder;
import com.example.cloud_config_client.entity.sysUser;
import com.example.cloud_config_client.server.UserServer;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class CloudConfigClientApplication {

	private Logger logger = LoggerFactory.getLogger(Logger.class);

	@Value("${label}")
	private String label;
	@Value("${mqconfig}")
	private String mqconfig;
	@Value("${maconfig}")
	private String maconfig;
	@Autowired
	private UserServer userServer;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping("start1")
	public String hello() throws Exception {
		System.out.println(String.format("参数[mqconfig=%s],[maconfig=%s]", mqconfig,maconfig));
		List<sysUser> list = userServer.findAll();
		// 查找mysql数据库信息
		if (list != null && list.size() > 0) {
			for (sysUser user : list) {
				logger.info("-----Mysql-------");
				System.out.println(user.toString());
			}
		}
		// 查找mongo数据库数据
		List<AuditOrder> orderList = mongoTemplate.findAll(AuditOrder.class);
		System.out.println("-------MongoDB---------");
		System.out.println(mapper.writeValueAsString(orderList));

		return label + " hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}
}
