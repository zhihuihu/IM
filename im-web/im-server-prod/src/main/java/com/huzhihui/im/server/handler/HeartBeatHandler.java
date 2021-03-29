/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.handler;

import com.huzhihui.im.common.dto.ImUserInfo;
import com.huzhihui.im.common.properties.ImServerProperties;
import com.huzhihui.im.server.utils.NettyAttrUtil;
import com.huzhihui.im.server.utils.SessionSocketUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 心跳处理器
 * @author huzhi
 * @version $ v 0.1 2021/3/29 20:24 huzhi Exp $$
 */
@Component
public class HeartBeatHandler {

    private static final Logger log = LoggerFactory.getLogger(HeartBeatHandler.class);

    @Autowired
    private ImServerProperties imServerProperties;
    @Autowired
    private OnlineHandler onlineHandler;

    public void process(ChannelHandlerContext ctx) {
        long heartBeatTime = imServerProperties.getHeartbeatTime() * 1000;

        Long lastReadTime = NettyAttrUtil.getReaderTime(ctx.channel());
        long now = System.currentTimeMillis();
        if (lastReadTime != null && now - lastReadTime > heartBeatTime){
            ImUserInfo imUserInfo = SessionSocketUtils.getImUserInfoSession((NioSocketChannel) ctx.channel());
            if (imUserInfo != null){
                log.warn("客户端[{}]心跳超时[{}]ms，需要关闭连接!",imUserInfo.getUserName(),now - lastReadTime);
            }
            onlineHandler.offline(imUserInfo,(NioSocketChannel) ctx.channel());
            ctx.channel().close();
        }
    }
}
