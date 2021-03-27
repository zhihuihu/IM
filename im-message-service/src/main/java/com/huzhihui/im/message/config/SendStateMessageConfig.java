/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.config;

import com.huzhihui.im.message.constant.SendStateMessageConstant;
import com.huzhihui.im.message.producer.SendStateMessageProducer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * 消息发送状态
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:36 huzhi Exp $$
 */
public class SendStateMessageConfig {

    private static final String EXCHANGE_NAME = SendStateMessageConstant.EXCHANGE_NAME;

    private static final String QUEUE_NAME = SendStateMessageConstant.QUEUE_NAME;

    private static final String QUEUE_ROUTE_KEY = SendStateMessageConstant.QUEUE_ROUTE_KEY;

    private static final String PRODUCER_NAME = SendStateMessageConstant.PRODUCER_NAME;

    /**
     * 队列
     * @return
     */
    @Bean(name = QUEUE_NAME)
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    /**
     * 绑定交换机
     * @param queue
     * @return
     */
    @Bean(name = EXCHANGE_NAME)
    public AbstractExchange exchange(@Qualifier(QUEUE_NAME) Queue queue, RabbitAdmin rabbitAdmin) {
        DirectExchange directExchange = new DirectExchange(EXCHANGE_NAME);
        //--通过路由绑定队列到对应交换机
        rabbitAdmin.declareExchange(directExchange);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(directExchange).with(QUEUE_ROUTE_KEY));
        return directExchange;
    }

    /**
     * 生产者
     * @param amqpTemplate
     * @return
     */
    @Bean(name = PRODUCER_NAME)
    public SendStateMessageProducer messageProducer(AmqpTemplate amqpTemplate) {
        return new SendStateMessageProducer(amqpTemplate);
    }

}
