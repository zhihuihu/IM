/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.handler;

import com.huzhihui.im.message.dto.SendMessage;
import com.huzhihui.im.message.producer.SendMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:51 huzhi Exp $$
 */
@SuppressWarnings("ALL")
@Component
public class MqMessageHandler {

    @Autowired
    private SendMessageProducer sendMessageProducer;

    /**
     * 发送消息
     * @param sendMessage
     */
    public void sendSendMessage(SendMessage sendMessage){
        sendMessageProducer.sendMessage(sendMessage);
    }

}
