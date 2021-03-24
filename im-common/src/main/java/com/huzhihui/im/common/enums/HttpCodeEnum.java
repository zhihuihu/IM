package com.huzhihui.im.common.enums;

/**
 * http响应枚举
 * @author huzhi
 * @version $ v 0.1 2021/3/22 19:56 huzhi Exp $$
 */
public enum HttpCodeEnum {

    SUCCESS(1000,"操作成功"),
    ERROR(5000,"服务异常");
    ;

    private int code;

    private String desc;

    HttpCodeEnum(int code, String desc) {
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
