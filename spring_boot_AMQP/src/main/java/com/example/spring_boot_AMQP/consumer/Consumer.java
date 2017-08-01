package com.example.spring_boot_AMQP.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息
 * @author Dell
 *
 */
@Component
@RabbitListener(queues="SEE_YOU")
public class Consumer {
	@RabbitHandler
	public void receive(String hello){
		System.out.println("consumer:"+hello);
	}

}
