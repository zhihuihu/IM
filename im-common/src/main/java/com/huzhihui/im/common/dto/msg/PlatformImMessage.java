/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.dto.msg;

/**
 * 平台通知消息
 * @author huzhi
 * @version $ v 0.1 2021/3/24 21:43 huzhi Exp $$
 */
public class PlatformImMessage extends BaseImMessage {

    /** 接收者 */
    private String toUserId;
    /** 数据 */
    private String data;

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
