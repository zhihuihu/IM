package com.huzhihui.im.message.producer.inter;

import com.huzhihui.im.message.dto.AbstractMessage;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:18 huzhi Exp $$
 */
public interface MessageProducer<T extends AbstractMessage> {

    /**
     * 发送普通消息
     * @param exchangeTag
     * @param queueTag
     * @param message
     */
    void sendMessage(String exchangeTag, String queueTag, T message);

    /**
     * 发送延时消息-延时插件方式
     * @param exchangeTag
     * @param queueTag
     * @param message
     * @param messagePostProcessor
     */
    void sendMessage(String exchangeTag, String queueTag, T message, MessagePostProcessor messagePostProcessor);

}
