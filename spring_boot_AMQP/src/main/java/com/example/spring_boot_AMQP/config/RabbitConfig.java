package com.example.spring_boot_AMQP.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
	//定义属性并且创建get方法，方便在其他地方使用
	@Value("${mqConfig.see.queue}")
	private String seeYou;
	@Value("${mqConfig.see.binding}")
	private String seeYouKey;
	@Value("${mqConfig.test.queue}")
	private String testQueue;
	@Value("${mqConfig.test.binding}")
	private String testQueueKey;
	
	//生成Get方法
	public String getSeeYou() {
		return seeYou;
	}
	public String getSeeYouKey() {
		return seeYouKey;
	}
	public String getTestQueue() {
		return testQueue;
	}
	public String getTestQueueKey() {
		return testQueueKey;
	}

	//创建队列
	@Bean
	public Queue queue1(){
		return new Queue(seeYou);
	}

	@Bean
	public Queue queue2(){
		return new Queue(testQueue);
	}
   /*创建交换机 */
    //Direct Exchange是RabbitMQ默认的交换机模式，也是最简单的模式，根据key全文匹配去寻找队列。
	@Bean
	public DirectExchange seeYouChange(){
		return new DirectExchange(testQueueKey);
	}
	//Topic Exchange 转发消息主要是根据通配符
	@Bean
	public TopicExchange seeTopicChange(){
		return new TopicExchange(seeYouKey);
	}
	/*Headers Exchange
	 * headers 也是根据规则匹配, 相较于 direct 和 topic 固定地使用 routing_key ,
	 *  headers 则是一个自定义匹配规则的类型. 在队列与交换器绑定时, 会设定一组键值对规则, 
	 *  消息中也包括一组键值对( headers 属性), 当这些键值对有一对, 或全部匹配时, 消息被投送到对应队列.
	 */
	@Bean
	public HeadersExchange seeHeaderChange(){
		return new HeadersExchange(testQueueKey);
	}
	/*
	 * Fanout Exchange 消息广播的模式，不管路由键或者是路由模式，会把消息发给绑定给它的全部队列，如果配置了routing_key会被忽略。
	 */
	@Bean
	public FanoutExchange seeFanoutChange(){
		return new FanoutExchange(testQueueKey);
	}
	//交换机和队列之间的绑定
	@Bean
	public Binding bindingExchangeDirect(Queue queue2,DirectExchange  seeYouChange){
		return BindingBuilder.bind(queue2).to(seeYouChange).with(testQueueKey);
	}
	 
}
