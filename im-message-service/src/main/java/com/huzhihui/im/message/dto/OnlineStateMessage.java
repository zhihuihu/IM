/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.dto;

/**
 * 在线状态
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:27 huzhi Exp $$
 */
public class OnlineStateMessage extends AbstractMessage {

    /** 用户ID */
    private String userId;
    /** 在线状态 true在线，false离线 */
    private Boolean online;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
