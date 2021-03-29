/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.producer;

import com.huzhihui.im.message.constant.KickOutMessageConstant;
import com.huzhihui.im.message.constant.OnlineStateMessageConstant;
import com.huzhihui.im.message.dto.KickOutMessage;
import com.huzhihui.im.message.dto.OnlineStateMessage;
import com.huzhihui.im.message.producer.inter.AbstractMessageProducer;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:41 huzhi Exp $$
 */
public class KickOutMessageProducer extends AbstractMessageProducer<KickOutMessage> {


    private static final String EXCHANGE_KEY = KickOutMessageConstant.EXCHANGE_NAME;
    private static final String QUEUE_KEY = KickOutMessageConstant.QUEUE_NAME;

    public KickOutMessageProducer(AmqpTemplate amqpTemplate) {
        super(amqpTemplate);
    }

    @Override
    public void sendMessage(KickOutMessage kickOutMessage) {
        super.sendMessage(EXCHANGE_KEY, QUEUE_KEY, kickOutMessage);
    }
}
