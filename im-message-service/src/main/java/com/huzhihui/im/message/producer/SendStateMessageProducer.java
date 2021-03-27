/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.producer;

import com.huzhihui.im.message.constant.SendStateMessageConstant;
import com.huzhihui.im.message.dto.SendStateMessage;
import com.huzhihui.im.message.producer.inter.AbstractMessageProducer;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:42 huzhi Exp $$
 */
public class SendStateMessageProducer extends AbstractMessageProducer<SendStateMessage> {

    private static final String EXCHANGE_KEY = SendStateMessageConstant.EXCHANGE_NAME;
    private static final String QUEUE_KEY = SendStateMessageConstant.QUEUE_NAME;

    public SendStateMessageProducer(AmqpTemplate amqpTemplate) {
        super(amqpTemplate);
    }

    @Override
    public void sendMessage(SendStateMessage sendStateMessage) {
        super.sendMessage(EXCHANGE_KEY, QUEUE_KEY, sendStateMessage);
    }
}
