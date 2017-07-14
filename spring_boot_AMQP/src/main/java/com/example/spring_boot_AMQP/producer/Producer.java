package com.example.spring_boot_AMQP.producer;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 * @author Dell
 *
 */
@Component
public class Producer {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void sender(){
		String context = "hello"+new Date();
		System.out.println(context);
		this.amqpTemplate.convertAndSend("SEE_YOU",context);
	}

}
