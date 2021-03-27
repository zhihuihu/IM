/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.dto;

/**
 * 消息发送状态
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:30 huzhi Exp $$
 */
public class SendStateMessage extends AbstractMessage {

    /** 发送的消息ID */
    private String sendMessageId;
    /** 发送状态 true 成功  false 失败 */
    private Boolean success;

    public String getSendMessageId() {
        return sendMessageId;
    }

    public void setSendMessageId(String sendMessageId) {
        this.sendMessageId = sendMessageId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
