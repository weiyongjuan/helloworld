package com.example.spring_boot_AMQP.consumer;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 接收消息
 * @author Dell
 *
 */
@Component
@EnableRabbit
public class Consumer {
	@RabbitListener(queues="${mqConfig.test.queue}")
	public void receive(String message){
		
		System.out.println("consumer:"+message);
	}

}
