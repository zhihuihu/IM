/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.client.handler;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.common.constant.RedisConstant;
import com.huzhihui.im.common.dto.ImUserInfo;
import com.huzhihui.im.common.dto.TransferMsg;
import com.huzhihui.im.common.dto.msg.LoginMessage;
import com.huzhihui.im.common.enums.TcpCommandTypeEnum;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huzhi
 * @version $ v 0.1 2021/4/2 21:11 huzhi Exp $$
 */
@ChannelHandler.Sharable
public class SocketClientHandler extends SimpleChannelInboundHandler<String> {

    private static final Logger log = LoggerFactory.getLogger(SocketClientHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt ;

            if (idleStateEvent.state() == IdleState.WRITER_IDLE){
                TransferMsg transferMsg = new TransferMsg();
                transferMsg.setCommandType(TcpCommandTypeEnum.PING.getCode());
                ctx.writeAndFlush(JSON.toJSONString(transferMsg)).addListeners((ChannelFutureListener) future -> {
                    if (!future.isSuccess()) {
                        log.error("IO error,close Channel");
                        future.channel().close();
                    }
                }) ;
            }

        }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        TransferMsg transferMsg = JSON.parseObject(s,TransferMsg.class);
        if(transferMsg.getCommandType() == TcpCommandTypeEnum.MSG.getCode()){
            // 消息
            log.info(s);
        }else if(transferMsg.getCommandType() == TcpCommandTypeEnum.PING.getCode()){
            log.info("收到服务端心跳！！！");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("断线");
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }


}
