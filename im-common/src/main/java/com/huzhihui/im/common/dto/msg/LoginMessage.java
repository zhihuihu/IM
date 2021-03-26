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

    /** 用户ID */
    private String userId;
    /** 用户名 */
    private String userName;
    /** 用户中文名 */
    private String userCname;

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
}
