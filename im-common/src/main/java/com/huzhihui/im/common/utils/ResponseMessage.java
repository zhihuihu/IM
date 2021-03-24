/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.utils;

import com.huzhihui.im.common.enums.HttpCodeEnum;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:03 huzhi Exp $$
 */
public class ResponseMessage<T> {

    /**
     * 操作成功失败
     */
    private boolean success = false;
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息提示
     */
    private String codeMessage;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功返回结果
     *
     * @return 返回结果
     */
    public static ResponseMessage success() {
        return success(HttpCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 成功返回结果
     *
     * @param codeMessage 返回编码提示
     * @return
     */
    public static ResponseMessage success(String codeMessage) {
        return new ResponseMessage(true, HttpCodeEnum.SUCCESS.getCode(), codeMessage, null);
    }

    /**
     * 成功返回结果
     *
     * @param codeMessage 返回编码提示
     * @return
     */
    public static ResponseMessage success(Integer code, String codeMessage) {
        return new ResponseMessage(true, code, codeMessage, null);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage success(T data) {
        return new ResponseMessage(true, HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage success(String codeMessage, T data) {
        return new ResponseMessage(true, HttpCodeEnum.SUCCESS.getCode(), codeMessage, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage success(T data, Long count) {
        return new ResponsePageMessage(true, HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), data, count, null);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage success(T data, Long count, Long pages) {
        return new ResponsePageMessage(true, HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), data, count, pages);
    }


    /**
     * 成功返回结果
     *
     * @param codeMessage
     * @param data
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage success(String codeMessage, T data, Long count, Long pages) {
        return new ResponsePageMessage(true, HttpCodeEnum.SUCCESS.getCode(), codeMessage, data, count, pages);
    }

    /**
     * 失败返回结果
     *
     * @return
     */
    public static ResponseMessage failure() {
        return new ResponseMessage(false, HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getDesc(), null);
    }

    /**
     * 失败返回结果
     *
     * @param codeMessage 失败消息
     * @return
     */
    public static ResponseMessage failure(String codeMessage) {
        return new ResponseMessage(false, HttpCodeEnum.ERROR.getCode(), codeMessage, null);
    }

    public static ResponsePageMessage failurePage(String codeMessage) {
        return new ResponseMessage.ResponsePageMessage(false, HttpCodeEnum.ERROR.getCode(), codeMessage, null, 0L, 0L);
    }

    /**
     * 失败返回结果
     *
     * @param data
     * @return
     */
    public static <T> ResponseMessage failure(T data) {
        return new ResponseMessage(false, HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getDesc(), data);
    }

    /**
     * 失败返回结果
     *
     * @param codeMessage 失败消息
     * @return
     */
    public static ResponseMessage failure(Integer code, String codeMessage) {
        return new ResponseMessage(false, code, codeMessage, null);
    }

    public ResponseMessage(boolean success, Integer code, String codeMessage, T data) {
        this.success = success;
        this.code = code;
        this.codeMessage = codeMessage;
        this.data = data;
    }

    public ResponseMessage() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return codeMessage;
    }

    public void setCodeMessage(String codeMessage) {
        this.codeMessage = codeMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 分页返回数据
     *
     * @param <T>
     */
    public static class ResponsePageMessage<T> extends ResponseMessage<T> {

        /**
         * 总记录数
         */
        private Long count;

        /**
         * 总页数
         */
        private Long pages;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public Long getPages() {
            return pages;
        }

        public void setPages(Long pages) {
            this.pages = pages;
        }

        public ResponsePageMessage(boolean success, Integer code, String codeMessage, T data, Long count, Long pages) {
            super(success, code, codeMessage, data);
            this.count = count;
            this.pages = pages;
        }

        public ResponsePageMessage() {
        }

        public static ResponsePageMessage failure(String codeMessage) {
            return new ResponsePageMessage(false, HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getDesc(), codeMessage, 0L, 0L);
        }
    }
}
