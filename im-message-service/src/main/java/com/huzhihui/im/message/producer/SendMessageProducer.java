/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.producer;

import com.huzhihui.im.message.constant.SendMessageConstant;
import com.huzhihui.im.message.dto.SendMessage;
import com.huzhihui.im.message.producer.inter.AbstractMessageProducer;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:40 huzhi Exp $$
 */
public class SendMessageProducer extends AbstractMessageProducer<SendMessage> {

    private static final String EXCHANGE_KEY = SendMessageConstant.EXCHANGE_NAME;
    private static final String QUEUE_KEY = SendMessageConstant.QUEUE_NAME;

    public SendMessageProducer(AmqpTemplate amqpTemplate) {
        super(amqpTemplate);
    }

    @Override
    public void sendMessage(SendMessage sendMessage) {
        super.sendMessage(EXCHANGE_KEY, QUEUE_KEY, sendMessage);
    }
}
