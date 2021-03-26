/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.handler;

import com.huzhihui.im.server.handler.socket.SocketServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 21:19 huzhi Exp $$
 */
public class ImServerSocketInitializer extends ChannelInitializer<Channel> {

    private final SocketServerHandler socketServerHandler = new SocketServerHandler();


    @Override
    protected void initChannel(Channel channel) throws Exception {

        channel.pipeline()
                // 11 秒没有向客户端发送消息就发生心跳
                .addLast(new IdleStateHandler(11, 0, 0))
                //
                .addLast(new LengthFieldBasedFrameDecoder(65532,0,4,0,4))
                .addLast(new StringDecoder())
                .addLast(new LengthFieldPrepender(4))
                .addLast(new StringEncoder())
                .addLast(socketServerHandler);
    }
}
