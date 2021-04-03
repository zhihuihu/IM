package com.huzhihui.im.common.enums;

/**
 * tcp消息类型枚举
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:28 huzhi Exp $$
 */
public enum MessageTypeEnum {

    P2P(1,"单聊"),
    GROUP(2,"群聊"),
    PLATFORM(3,"平台通知");
    ;

    private int code;

    private String desc;

    MessageTypeEnum(int code, String desc) {
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
