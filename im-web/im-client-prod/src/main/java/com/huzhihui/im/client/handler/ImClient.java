/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.client.handler;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.client.dto.ImServerInfoDto;
import com.huzhihui.im.common.dto.TransferMsg;
import com.huzhihui.im.common.dto.msg.LoginMessage;
import com.huzhihui.im.common.enums.TcpCommandTypeEnum;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author huzhi
 * @version $ v 0.1 2021/4/2 21:30 huzhi Exp $$
 */
@Configuration
public class ImClient {

    private static final Logger log = LoggerFactory.getLogger(ImClient.class);

    private EventLoopGroup group = new NioEventLoopGroup(0, new DefaultThreadFactory("cim-work"));

    /*@Value("${cim.user.userName}")
    private String userName;

    @Value("${cim.user.userName}")
    private String password;*/

    private SocketChannel channel;

    @PostConstruct
    public void start() throws Exception {

        ImServerInfoDto imServerInfoDto = new ImServerInfoDto();
        imServerInfoDto.setIp("127.0.0.1");
        imServerInfoDto.setPort(12000);
        //启动客户端
        startClient(imServerInfoDto);

        //向服务端注册
        loginCIMServer();


    }

    /**
     * 启动客户端
     *
     * @param imServerInfoDto
     * @throws Exception
     */
    private void startClient(ImServerInfoDto imServerInfoDto) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ImClientSocketInitializer())
        ;

        ChannelFuture future = null;
        try {
            future = bootstrap.connect(imServerInfoDto.getIp(), imServerInfoDto.getPort()).sync();
        } catch (Exception e) {

            log.error("Connect fail!", e);
        }
        if (future.isSuccess()) {
            log.info("启动 cim client 成功");
        }
        channel = (SocketChannel) future.channel();
    }

    /**
     * 向服务器注册
     */
    private void loginCIMServer() {
        TransferMsg transferMsg = new TransferMsg();
        transferMsg.setCommandType(TcpCommandTypeEnum.LOGIN.getCode());
        LoginMessage loginMessage = new LoginMessage();
        loginMessage.setToken("b5829d8f55e74d0d9df75c49b905cf0c");
        transferMsg.setLoginMessage(loginMessage);
        ChannelFuture future = channel.writeAndFlush(JSON.toJSONString(transferMsg));
        future.addListener((ChannelFutureListener) channelFuture ->
                log.info("Registry cim server success!")
        );
    }
}
