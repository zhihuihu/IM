/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.dto;

import java.io.Serializable;

/**
 * 基础消息类所有都要集成
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:18 huzhi Exp $$
 */
public abstract class AbstractMessage implements Serializable {

    /** 消息ID */
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
