/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.handler;

import com.huzhihui.im.common.dto.ImUserInfo;
import com.huzhihui.im.message.dto.OnlineStateMessage;
import com.huzhihui.im.server.utils.SessionSocketUtils;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 上下线处理器
 * @author huzhi
 * @version $ v 0.1 2021/3/29 20:33 huzhi Exp $$
 */
@Component
public class OnlineHandler {

    @Autowired
    private MqMessageHandler mqMessageHandler;

    /**
     * 在线
     * @param imUserInfo
     * @param nioSocketChannel
     */
    public void online(ImUserInfo imUserInfo,NioSocketChannel nioSocketChannel){
        OnlineStateMessage onlineStateMessage = new OnlineStateMessage();
        onlineStateMessage.setUserId(imUserInfo.getUserId());
        onlineStateMessage.setOnline(true);
        mqMessageHandler.sendOnlineStateMessage(onlineStateMessage);
        SessionSocketUtils.setImUserInfoSession(imUserInfo.getUserId(),imUserInfo);
        SessionSocketUtils.setNioSocketChannelSession(imUserInfo.getUserId(),nioSocketChannel);
    }

    /**
     * 下线
     * @param imUserInfo
     * @param nioSocketChannel
     */
    public void offline(ImUserInfo imUserInfo,NioSocketChannel nioSocketChannel){
        OnlineStateMessage onlineStateMessage = new OnlineStateMessage();
        onlineStateMessage.setUserId(imUserInfo.getUserId());
        onlineStateMessage.setOnline(false);
        mqMessageHandler.sendOnlineStateMessage(onlineStateMessage);
        SessionSocketUtils.clearImUserInfoSession(imUserInfo.getUserId());
        SessionSocketUtils.clearNioSocketChannelSession(imUserInfo.getUserId());
        nioSocketChannel.close();
    }
}
