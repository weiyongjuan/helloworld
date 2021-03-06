package com.example.spring_boot_AMQP.producer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_AMQP.Entity.sysUser;
import com.example.spring_boot_AMQP.config.RabbitConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 发送消息
 * @author Dell
 *
 */
@RestController
public class Producer {
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private RabbitConfig rabbitConfig;
	
	private ObjectMapper mapper =  new ObjectMapper();
	
	@RequestMapping(value="/helo")
	public void sender() throws AmqpException, Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		sysUser user = new sysUser();
		user.setUserName("张三");
		user.setPhone("13301347137");
		String context = "hello "+new Date();
		System.out.println(context);
		map.put("data", user);
		map.put("code", 200);
		map.put("message", "发送数据");
		this.amqpTemplate.convertAndSend(rabbitConfig.getMyConfigExchange(),rabbitConfig.getMqConfigQueueBinding(),mapper.writeValueAsString(map));
	
	}

}
