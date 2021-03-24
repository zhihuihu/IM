package com.huzhihui.im.common.enums;

/**
 * TCP响应编码枚举类
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:26 huzhi Exp $$
 */
public enum TcpCodeEnum {

    SUCCESS(1000,"操作成功"),
    ERROR(5000,"服务异常");
    ;

    private int code;

    private String desc;

    TcpCodeEnum(int code, String desc) {
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
