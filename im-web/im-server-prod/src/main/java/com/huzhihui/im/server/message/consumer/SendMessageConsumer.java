/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.message.consumer;

import com.huzhihui.im.message.constant.SendMessageConstant;
import com.huzhihui.im.message.dto.SendMessage;
import com.huzhihui.im.server.config.RabbitMqConfig;
import com.huzhihui.im.server.utils.SessionSocketUtils;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * router路由过来的消息-消费者
 * @author huzhi
 * @version $ v 0.1 2021/3/29 20:44 huzhi Exp $$
 */
@Component
@RabbitListener(queues = SendMessageConstant.QUEUE_NAME,containerFactory = RabbitMqConfig.MESSAGE_RABBITMQ_CONTAINER_FACTORY)
public class SendMessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(SendMessageConsumer.class);

    @RabbitHandler
    public void consume(SendMessage sendMessage){
        NioSocketChannel socketChannel = SessionSocketUtils.getNioSocketChannelSession(sendMessage.getToUserId());
        if(null != socketChannel){

        }
    }
}
