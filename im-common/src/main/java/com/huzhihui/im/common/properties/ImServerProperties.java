/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.properties;

/**
 * IM 服务配置类
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:13 huzhi Exp $$
 */
public class ImServerProperties {

    private String ip;
    /** socket端口 */
    private int socketPort;
    /** websocket端口 */
    private int websocketPort;
    /** 心跳时间 */
    private int heartbeatTime;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getSocketPort() {
        return socketPort;
    }

    public void setSocketPort(int socketPort) {
        this.socketPort = socketPort;
    }

    public int getWebsocketPort() {
        return websocketPort;
    }

    public void setWebsocketPort(int websocketPort) {
        this.websocketPort = websocketPort;
    }

    public int getHeartbeatTime() {
        return heartbeatTime;
    }

    public void setHeartbeatTime(int heartbeatTime) {
        this.heartbeatTime = heartbeatTime;
    }
}
