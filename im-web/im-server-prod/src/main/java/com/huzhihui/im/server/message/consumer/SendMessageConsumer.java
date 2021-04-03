/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.message.consumer;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.common.dto.TransferMsg;
import com.huzhihui.im.common.dto.msg.GroupImMessage;
import com.huzhihui.im.common.dto.msg.P2pImMessage;
import com.huzhihui.im.common.dto.msg.PlatformImMessage;
import com.huzhihui.im.common.enums.MessageTypeEnum;
import com.huzhihui.im.common.enums.TcpCommandTypeEnum;
import com.huzhihui.im.message.constant.SendMessageConstant;
import com.huzhihui.im.message.dto.SendMessage;
import com.huzhihui.im.server.config.RabbitMqConfig;
import com.huzhihui.im.server.utils.SessionSocketUtils;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
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
        try{
            NioSocketChannel socketChannel = SessionSocketUtils.getNioSocketChannelSession(sendMessage.getToUserId());
            if(null != socketChannel){
                TransferMsg transferMsg = new TransferMsg();
                transferMsg.setMessageType(sendMessage.getMessageType());
                transferMsg.setCommandType(TcpCommandTypeEnum.MSG.getCode());
                if(MessageTypeEnum.P2P.getCode() == sendMessage.getMessageType()){
                    P2pImMessage p2pImMessage = JSON.parseObject(sendMessage.getMessage(),P2pImMessage.class);
                    transferMsg.setP2pImMessage(p2pImMessage);
                }else if(MessageTypeEnum.GROUP.getCode() == sendMessage.getMessageType()){
                    GroupImMessage groupImMessage = JSON.parseObject(sendMessage.getMessage(),GroupImMessage.class);
                    transferMsg.setGroupImMessage(groupImMessage);
                }else if(MessageTypeEnum.PLATFORM.getCode() == sendMessage.getMessageType()){
                    PlatformImMessage platformImMessage = JSON.parseObject(sendMessage.getMessage(),PlatformImMessage.class);
                    transferMsg.setPlatformImMessage(platformImMessage);
                }
                ChannelFuture future = socketChannel.writeAndFlush(JSON.toJSONString(transferMsg));
                future.addListener((ChannelFutureListener) channelFuture ->
                        log.info("server push msg:[{}]", JSON.toJSONString(transferMsg)));
            }
        }catch (Exception ex){
            log.error("失败",ex);
        }
    }
}
