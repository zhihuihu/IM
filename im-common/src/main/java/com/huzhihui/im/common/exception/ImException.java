/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.exception;

/**
 * IM 异常
 * @author huzhi
 * @version $ v 0.1 2021/3/23 19:37 huzhi Exp $$
 */
public class ImException extends RuntimeException {

    private Integer code;

    private String message;

    private Throwable cause;

    public ImException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ImException(Integer code, String message, Throwable cause) {
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
