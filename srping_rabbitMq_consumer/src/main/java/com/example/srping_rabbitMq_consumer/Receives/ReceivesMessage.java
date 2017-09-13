package com.example.srping_rabbitMq_consumer.Receives;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceivesMessage {
@RabbitListener(queues="${mqConfig.see.queue}")
	
	public void receive(String message){
		System.out.println("consumer:"+message);
	}

}
