package com.example.spring_boot_AMQP.producer;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_AMQP.Entity.sysUser;

/**
 * 发送消息
 * @author Dell
 *
 */
@RestController
public class Producer {
	@Autowired
	private AmqpTemplate amqpTemplate;
	@RequestMapping(value="/helo")
	public void sender(){
		sysUser user = new sysUser();
		user.setUserName("张三");
		user.setPhone("13301347137");
		String context = "hello "+new Date();
		System.out.println(context);
		this.amqpTemplate.convertAndSend("SEE_YOU",user.toString());
	}

}
