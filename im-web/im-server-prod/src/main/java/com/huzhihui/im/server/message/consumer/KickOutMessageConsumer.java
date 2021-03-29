/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.message.consumer;

import com.huzhihui.im.message.constant.KickOutMessageConstant;
import com.huzhihui.im.message.dto.KickOutMessage;
import com.huzhihui.im.server.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 剔除通道连接
 * @author huzhi
 * @version $ v 0.1 2021/3/29 20:18 huzhi Exp $$
 */
@Component
@RabbitListener(queues = KickOutMessageConstant.QUEUE_NAME,containerFactory = RabbitMqConfig.MESSAGE_RABBITMQ_CONTAINER_FACTORY)
public class KickOutMessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(KickOutMessageConsumer.class);

    @RabbitHandler
    public void consume(KickOutMessage kickOutMessage){

    }
}
