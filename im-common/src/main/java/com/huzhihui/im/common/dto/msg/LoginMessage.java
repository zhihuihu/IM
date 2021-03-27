/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.dto.msg;


/**
 * 登录对象
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:09 huzhi Exp $$
 */
public class LoginMessage extends BaseImMessage {

    /** 只需要token即可 */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
