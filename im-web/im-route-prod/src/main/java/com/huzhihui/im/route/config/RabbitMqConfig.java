/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.config;

import com.huzhihui.im.message.config.OnlineStateMessageConfig;
import com.huzhihui.im.message.config.SendMessageConfig;
import com.huzhihui.im.message.config.SendStateMessageConfig;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:47 huzhi Exp $$
 */
@Configuration
@ImportAutoConfiguration(value = {
        OnlineStateMessageConfig.class,
        SendMessageConfig.class,
        SendStateMessageConfig.class
})
public class RabbitMqConfig {

    /** rabbitmq 消息监听ListenerContainerFactory */
    public static final String MESSAGE_RABBITMQ_CONTAINER_FACTORY = "messageContainerFactory";
    public static final String DELAY_MESSAGE_RABBITMQ_CONTAINER_FACTORY = "delayMessageContainerFactory";

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean(MESSAGE_RABBITMQ_CONTAINER_FACTORY)
    public SimpleRabbitListenerContainerFactory messageContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, CachingConnectionFactory cachingConnectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(10);
        factory.setMaxConcurrentConsumers(10);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        configurer.configure(factory, cachingConnectionFactory);
        return factory;
    }

    @Bean(DELAY_MESSAGE_RABBITMQ_CONTAINER_FACTORY)
    public SimpleRabbitListenerContainerFactory delayMessageContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, CachingConnectionFactory cachingConnectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(10);
        factory.setMaxConcurrentConsumers(10);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        configurer.configure(factory, cachingConnectionFactory);
        return factory;
    }


}
