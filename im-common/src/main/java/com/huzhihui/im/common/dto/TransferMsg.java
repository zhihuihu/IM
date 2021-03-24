/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.dto;


import com.huzhihui.im.common.dto.msg.GroupImMessage;
import com.huzhihui.im.common.dto.msg.P2pImMessage;
import com.huzhihui.im.common.dto.msg.PlatformImMessage;

import java.io.Serializable;

/**
 * 数据传输对象
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:40 huzhi Exp $$
 */
public class TransferMsg implements Serializable {

    /** 消息指令类型 {@link com.huzhihui.im.common.enums.TcpCommandTypeEnum} */
    private int commandType;
    /** 消息类型 {@link com.huzhihui.im.common.enums.MessageTypeEnum} */
    private int messageType;
    /** 单聊 */
    private P2pImMessage p2pImMessage;
    /** 群聊 */
    private GroupImMessage groupImMessage;
    /** 平台通知 */
    private PlatformImMessage platformImMessage;

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public P2pImMessage getP2pImMessage() {
        return p2pImMessage;
    }

    public void setP2pImMessage(P2pImMessage p2pImMessage) {
        this.p2pImMessage = p2pImMessage;
    }

    public GroupImMessage getGroupImMessage() {
        return groupImMessage;
    }

    public void setGroupImMessage(GroupImMessage groupImMessage) {
        this.groupImMessage = groupImMessage;
    }

    public PlatformImMessage getPlatformImMessage() {
        return platformImMessage;
    }

    public void setPlatformImMessage(PlatformImMessage platformImMessage) {
        this.platformImMessage = platformImMessage;
    }
}
