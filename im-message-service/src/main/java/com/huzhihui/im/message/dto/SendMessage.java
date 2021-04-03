/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.dto;

/**
 * 发送的消息
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:33 huzhi Exp $$
 */
public class SendMessage extends AbstractMessage {

    /** 发送的消息ID */
    private String sendMessageId;
    /** 接收人 */
    private String toUserId;
    /** 消息类型 {@link com.huzhihui.im.common.enums.MessageTypeEnum} */
    private int messageType;
    /** 消息内容 */
    private String message;

    public String getSendMessageId() {
        return sendMessageId;
    }

    public void setSendMessageId(String sendMessageId) {
        this.sendMessageId = sendMessageId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
