/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.mongo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:19 huzhi Exp $$
 */
public class Pagination<T> implements Serializable {

    /** 每页显示条数 */
    private Integer pageSize = 10;

    /** 当前页 */
    private Integer currentPage = 1;

    /** 总页数 */
    private Integer totalPage = 1;

    /** 查询到的总数据量 */
    private Integer totalNumber = 0;

    /** 数据集 */
    private List<T> items;

    public Pagination(Integer currentPage, Integer pageSize, Integer totalNumber){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNumber = totalNumber;
    }

    public Integer getPageSize() {

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * 处理查询后的结果数据
     *
     * @param items 查询结果集
     */
    public void build(List items) {
        this.setItems(items);
        int count =  this.getTotalNumber();
        int divisor = count / this.getPageSize();
        int remainder = count % this.getPageSize();
        this.setTotalPage(remainder == 0 ? divisor == 0 ? 0 : divisor : divisor + 1);
    }
}
