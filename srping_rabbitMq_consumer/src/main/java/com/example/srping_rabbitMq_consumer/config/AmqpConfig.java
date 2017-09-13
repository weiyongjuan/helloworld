package com.example.srping_rabbitMq_consumer.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
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

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        //当容器空闲时，每隔６０秒就会发布事件
        factory.setIdleEventInterval(60000L);
        return factory;
    }


    @Override
   public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
    	registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
    }

   

}
