/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.dto;

/**
 * 剔除通道连接消息
 * @author huzhi
 * @version $ v 0.1 2021/3/29 20:13 huzhi Exp $$
 */
public class KickOutMessage extends AbstractMessage {

    /** 用户ID */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
