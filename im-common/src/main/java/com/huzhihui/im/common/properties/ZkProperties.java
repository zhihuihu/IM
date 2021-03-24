/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.properties;

/**
 * zk连接属性
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:09 huzhi Exp $$
 */
public class ZkProperties {

    /** 是否注册zk */
    private boolean register;
    /** 地址 */
    private String addr;
    /** zk连接超时时间 */
    private int connectTimeout;
    /** 注册根节点 */
    private String root;

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
