/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.handler.socket;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.common.dto.ImUserInfo;
import com.huzhihui.im.common.dto.TransferMsg;
import com.huzhihui.im.common.dto.msg.LoginMessage;
import com.huzhihui.im.common.enums.TcpCommandTypeEnum;
import com.huzhihui.im.server.handler.HeartBeatHandler;
import com.huzhihui.im.server.handler.OnlineHandler;
import com.huzhihui.im.server.handler.RedisHandler;
import com.huzhihui.im.server.utils.NettyAttrUtil;
import com.huzhihui.im.server.utils.SessionSocketUtils;
import com.huzhihui.im.server.utils.SpringBeanUtils;
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
 * socket消息处理类
 * @author huzhi
 * @version $ v 0.1 2021/3/22 21:16 huzhi Exp $$
 */
@ChannelHandler.Sharable
public class SocketServerHandler extends SimpleChannelInboundHandler<String> {

    private static final Logger log = LoggerFactory.getLogger(SocketServerHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {

                log.info("定时检测客户端端是否存活");

                HeartBeatHandler heartBeatHandler = SpringBeanUtils.getBean(HeartBeatHandler.class);
                heartBeatHandler.process(ctx);
            }
        }
        super.userEventTriggered(ctx, evt);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        TransferMsg transferMsg = JSON.parseObject(s,TransferMsg.class);
        if(transferMsg.getCommandType() == TcpCommandTypeEnum.LOGIN.getCode()){
            // 如果是登录
            LoginMessage loginMessage = transferMsg.getLoginMessage();
            RedisHandler redisHandler = SpringBeanUtils.getBean("redisHandler",RedisHandler.class);
            String userInfoStr = redisHandler.getValue(loginMessage.getToken());
            if(StringUtils.isEmpty(userInfoStr)){
                channelHandlerContext.channel().close();
            }
            ImUserInfo imUserInfo = JSON.parseObject(userInfoStr,ImUserInfo.class);
            OnlineHandler onlineHandler = SpringBeanUtils.getBean(OnlineHandler.class);
            onlineHandler.online(imUserInfo,(NioSocketChannel) channelHandlerContext.channel());

        }else if(transferMsg.getCommandType() == TcpCommandTypeEnum.MSG.getCode()){
            // 消息

        }else if(transferMsg.getCommandType() == TcpCommandTypeEnum.PING.getCode()){
            // 如果是PING消息
            NettyAttrUtil.updateReaderTime(channelHandlerContext.channel(),System.currentTimeMillis());
            //向客户端响应 pong 消息
            TransferMsg transferMsgPong = new TransferMsg();
            transferMsgPong.setCommandType(TcpCommandTypeEnum.PING.getCode());
            channelHandlerContext.writeAndFlush(JSON.toJSONString(transferMsgPong)).addListeners((ChannelFutureListener) future -> {
                if (!future.isSuccess()) {
                    log.error("IO error,close Channel");
                    future.channel().close();
                }
            }) ;
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ImUserInfo imUserInfo = SessionSocketUtils.getImUserInfoSession((NioSocketChannel) ctx.channel());
        if(imUserInfo != null){
            OnlineHandler onlineHandler = SpringBeanUtils.getBean(OnlineHandler.class);
            onlineHandler.offline(imUserInfo,(NioSocketChannel) ctx.channel());
            ctx.channel().close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }


}
