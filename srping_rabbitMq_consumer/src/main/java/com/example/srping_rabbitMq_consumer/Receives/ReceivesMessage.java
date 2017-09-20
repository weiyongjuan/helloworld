package com.example.srping_rabbitMq_consumer.Receives;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceivesMessage {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
    @RabbitListener(queues="${mqConfig.see.queue}")
	public void receive(String message){
		System.out.println("consumer:"+message);
	}
    @RabbitListener(queues="${mqConfig.test.queue}")
	public void Testreceive(String message){
		System.out.println("consumer:"+message);
	}

}
