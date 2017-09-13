package com.example.spring_boot_AMQP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * http://blog.csdn.net/column/details/rabbitmq.html
 * RabbitMQ从入门到精通
 * @author Dell
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqpApplication.class, args);
	}
}
