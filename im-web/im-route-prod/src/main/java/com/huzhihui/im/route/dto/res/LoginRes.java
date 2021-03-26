/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.dto.res;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:52 huzhi Exp $$
 */
public class LoginRes {

    /** token */
    private String token;
    /** 服务器IP */
    private String server;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
