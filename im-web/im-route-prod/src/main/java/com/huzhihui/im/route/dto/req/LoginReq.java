/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.dto.req;

/**
 * 登录签名DTO
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:50 huzhi Exp $$
 */
public class LoginReq {

    /** 用户ID */
    private String userId;
    /** 密码 */
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
