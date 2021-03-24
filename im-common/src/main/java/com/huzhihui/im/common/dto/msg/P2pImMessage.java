/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.dto.msg;

/**
 * p2p单聊消息
 * @author huzhi
 * @version $ v 0.1 2021/3/24 21:42 huzhi Exp $$
 */
public class P2pImMessage extends BaseImMessage {

    /** 发送者 */
    private String fromUserId;
    /** 接收者 */
    private String toUserId;
    /** 数据 */
    private String data;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

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
