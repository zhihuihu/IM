/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.mongo.dao;


import com.huzhihui.im.mongo.entity.Pagination;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:16 huzhi Exp $$
 */
public interface BaseMongoDao<T> {

    void insert(T entity);

    void insertAll(List<T> list);

    void insertAll(List<T> list, String collectionName);

    void update(T entity);

    void deleteAll(Class<T> entityClass);

    void deleteAll(List<T> list);

    void delete(T entity);

    void deleteById(String id, Class<T> entityClass);

    T selectById(String id, Class<T> entityClass);

    List<T> selectByIds(List<String> ids, Class<T> entityClass);

    List<T> selectByConditions(Query query, Class<T> entityClass);

    List<T> selectAll(Class<T> entityClass);

    long selectTotalCount(Query query, Class<T> entityClass);

}
