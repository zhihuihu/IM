/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.producer.inter;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.message.dto.AbstractMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:21 huzhi Exp $$
 */
public abstract class AbstractMessageProducer<T extends AbstractMessage> implements MessageProducer<T> {

    protected static final Logger log = LoggerFactory.getLogger(AbstractMessageProducer.class);

    protected AmqpTemplate amqpTemplate;

    public AbstractMessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendMessage(String exchangeTag, String queueTag, T message) {
        try {
            amqpTemplate.convertAndSend(exchangeTag, queueTag, message);
        } catch (Exception ex) {
            log.error("消息发送失败",ex);
        }
    }

    @Override
    public void sendMessage(String exchangeTag, String queueTag, T message, MessagePostProcessor messagePostProcessor) {
        try {
            amqpTemplate.convertAndSend(exchangeTag, queueTag, message, messagePostProcessor);
        } catch (Exception ex) {
            log.error("消息发送失败",ex);
        }
    }

    /**
     * 发送消息
     * @param t
     */
    public abstract void sendMessage(T t);

}
