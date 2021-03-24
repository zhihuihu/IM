package com.huzhihui.im.common.enums;

/**
 * tcp消息指令类型枚举
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:28 huzhi Exp $$
 */
public enum TcpCommandTypeEnum {

    LOGIN(1,"登录"),
    MSG(2,"业务消息"),
    PING(3,"ping");
    ;

    private int code;

    private String desc;

    TcpCommandTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
