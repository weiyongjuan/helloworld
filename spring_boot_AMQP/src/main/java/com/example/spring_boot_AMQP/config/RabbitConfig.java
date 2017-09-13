package com.example.spring_boot_AMQP.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *创建队列
 * @author Dell
 * http://www.ityouknow.com/springboot/2016/11/30/springboot(%E5%85%AB)-RabbitMQ%E8%AF%A6%E8%A7%A3.html
 *
 */
@Configuration
public class RabbitConfig {
	@Bean 
	RabbitAdmin rabbitAdmin(CachingConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	
	//定义属性并且创建get方法，方便在其他地方使用
	@Value("${mqConfig.see.queue}")
	private String seeYou;
	@Value("${mqConfig.see.binding}")
	private String seeYoubinding;
	@Value("${mqConfig.test.queue}")
	private String testQueue;
	@Value("${mqConfig.test.binding}")
	private String testQueuebinding;
	//交换机配置
	@Value("${mqConfig.exchange}")
	private String myConfigExchange;
	
	//生成Get方法
	public String getSeeYou() {
		return seeYou;
	}
	public String getSeeYoubinding() {
		return seeYoubinding;
	}
	public String getTestQueuebinding() {
		return testQueuebinding;
	}
	public String getTestQueue() {
		return testQueue;
	}
	public String getMyConfigExchange() {
		return myConfigExchange;
	}
	//创建队列
	@Bean
	public Queue seeQueue(RabbitAdmin rabbitAdmin){
		Queue queue = new Queue(seeYou);
		rabbitAdmin.declareQueue(queue);
		return queue;
	}

	@Bean
	public Queue testQueue(RabbitAdmin rabbitAdmin){
		Queue queue = new Queue(testQueue);
		rabbitAdmin.declareQueue(queue);
		return queue;
		
	}
   /*创建交换机 */
	//Topic Exchange 转发消息主要是根据通配符
	@Bean
	public TopicExchange seeTopicChange(RabbitAdmin rabbitAdmin){
		TopicExchange topicExchange = new TopicExchange(myConfigExchange,true,true);
		rabbitAdmin.declareExchange(topicExchange);
		return topicExchange;
	}

	//交换机和队列之间的绑定
	@Bean
	public Binding bindingExchangeDirect(RabbitAdmin rabbitAdmin,Queue testQueue,TopicExchange  seeTopicChange){
		Binding binding = BindingBuilder.bind(testQueue).to(seeTopicChange).with(testQueuebinding);
		rabbitAdmin.declareBinding(binding);
		return binding;
	}
	@Bean
	public Binding bindingExchangTopic(RabbitAdmin rabbitAdmin,Queue seeQueue,TopicExchange  seeTopicChange){
		Binding binding = BindingBuilder.bind(seeQueue).to(seeTopicChange).with(seeYoubinding);
		rabbitAdmin.declareBinding(binding);
		return binding;
	}
	 
}
