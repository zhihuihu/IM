/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.dto;

import java.io.Serializable;

/**
 * IM用户信息
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:18 huzhi Exp $$
 */
public class ImUserInfo implements Serializable {

    /** 用户ID */
    private String userId;
    /** 用户名 */
    private String userName;
    /** 用户中文名 */
    private String userCname;
    /** 服务器 */
    private String server;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
