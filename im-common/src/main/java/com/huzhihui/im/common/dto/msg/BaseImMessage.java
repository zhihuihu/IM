/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.dto.msg;

/**
 * 基础IM 消息对象
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:42 huzhi Exp $$
 */
public class BaseImMessage {

    /** 唯一请求编号 */
    private String requestNo;
    /** 请求时间戳 */
    private int timeStamp;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
