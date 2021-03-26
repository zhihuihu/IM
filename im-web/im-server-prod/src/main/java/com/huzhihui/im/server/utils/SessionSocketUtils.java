/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.utils;

import com.huzhihui.im.common.dto.ImUserInfo;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * session工具类
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:15 huzhi Exp $$
 */
public class SessionSocketUtils {

    /** socket通道 */
    private static final Map<String, NioSocketChannel> CHANNEL_MAP = new ConcurrentHashMap<>(16);
    /** 用户session */
    private static final Map<String, ImUserInfo> SESSION_MAP = new ConcurrentHashMap<>(16);

    /**
     * 设置nio通道信息
     * @param userId
     * @param nioSocketChannel
     */
    public static void setNioSocketChannelSession(String userId,NioSocketChannel nioSocketChannel){
        CHANNEL_MAP.put(userId,nioSocketChannel);
    }

    /**
     * 清除nio通道信息
     * @param userId
     */
    public static void clearNioSocketChannelSession(String userId){
        CHANNEL_MAP.remove(userId);
    }

    /**
     * 获取nio通道信息
     * @param userId
     * @return
     */
    public static NioSocketChannel getNioSocketChannelSession(String userId){
        return CHANNEL_MAP.get(userId);
    }

    public static void setImUserInfoSession(String userId,ImUserInfo imUserInfo){
        SESSION_MAP.put(userId,imUserInfo);
    }

    public static void clearImUserInfoSession(String userId){
        SESSION_MAP.remove(userId);
    }

    public static ImUserInfo getInUserInfoSession(String userId){
        return SESSION_MAP.get(userId);
    }
}
