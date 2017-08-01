package com.example.spring_boot_AMQP.producer;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		String context = "hello "+new Date();
		System.out.println(context);
		this.amqpTemplate.convertAndSend("SEE_YOU",context);
	}

}
