package com.example.srping_rabbitMq_consumer.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.GenericMessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
@EnableRabbit
public class AmqpConfig implements RabbitListenerConfigurer {

    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
    	DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
    	factory.setMessageConverter(new GenericMessageConverter());
    	return factory;
    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory ) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setConcurrentConsumers(3);
//        factory.setMaxConcurrentConsumers(10);
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        //如果消息确认机制设置为MANUAL(手动)则需要消费者接受到消息后给mq确认信息
//        //当容器空闲时，每隔６０秒就会发布事件
//        factory.setIdleEventInterval(60000L);
//        return factory;
//    }

    @Bean  
    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory ) {  
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);  
    
        container.setExposeListenerChannel(true);  
        container.setMaxConcurrentConsumers(10);  
        container.setConcurrentConsumers(3);  
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认  
        container.setMessageListener(new ChannelAwareMessageListener() {

            public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
                byte[] body = message.getBody();  
                System.out.println("收到消息 : " + new String(body));  
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费  

            }  

        });  
        return container;  
    }  
    
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
     	registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
     }
}

   

