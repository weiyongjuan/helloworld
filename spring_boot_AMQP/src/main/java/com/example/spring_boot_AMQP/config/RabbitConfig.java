package com.example.spring_boot_AMQP.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *创建队列
 * @author Dell
 *
 */
@Configuration
public class RabbitConfig {
	@Bean
	public Queue queue(){
		return new Queue("SEE_YOU");
	}

}
