/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.handler;

import com.huzhihui.im.message.dto.OnlineStateMessage;
import com.huzhihui.im.message.dto.SendStateMessage;
import com.huzhihui.im.message.producer.OnlineStateMessageProducer;
import com.huzhihui.im.message.producer.SendStateMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:54 huzhi Exp $$
 */
@SuppressWarnings("ALL")
@Component
public class MqMessageHandler {

    @Autowired
    private OnlineStateMessageProducer onlineStateMessageProducer;
    @Autowired
    private SendStateMessageProducer sendStateMessageProducer;

    public void sendOnlineStateMessage(OnlineStateMessage onlineStateMessage){
        onlineStateMessageProducer.sendMessage(onlineStateMessage);
    }

    public void sendSendStateMessage(SendStateMessage sendStateMessage){
        sendStateMessageProducer.sendMessage(sendStateMessage);
    }
}
