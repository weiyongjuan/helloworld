package com.example.spring_boot_AMQP.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 接收消息
 * @author Dell
 *
 */
@Component
@RabbitListener(queues="SEE_YOU")
public class Consumer {
	private ObjectMapper mapper = new ObjectMapper();
	@RabbitHandler
	public void receive(String message){
		
		System.out.println("consumer:"+message);
	}

}
