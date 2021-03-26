/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.mongo.dao.impl;

import com.huzhihui.im.mongo.dao.BaseMongoDao;
import com.huzhihui.im.mongo.entity.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:21 huzhi Exp $$
 */
public abstract class BaseMongoDaoImpl<T> implements BaseMongoDao<T> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public void insert(T entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void insertAll(List<T> list) {
        Integer len = list.size();
        for (int i = 0; i < len; i++) {
            mongoTemplate.save(list.get(i));
        }
    }

    @Override
    public void insertAll(List<T> list, String collectionName) {
        // BulkMode.UNORDERED:表示并行处理，遇到错误时能继续执行不影响其他操作；BulkMode.ORDERED：表示顺序执行，遇到错误时会停止所有执行
        BulkOperations ops = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, collectionName);
        ops.insert(list);
        // 执行操作
        ops.execute();
    }

    @Override
    public void update(T entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void deleteAll(Class<T> entityClass) {
        mongoTemplate.remove(new Query(), entityClass);
    }

    @Override
    public void deleteAll(List<T> list) {
        for (Object entity : list) {
            mongoTemplate.remove(entity);
        }
    }

    @Override
    public void delete(T entity) {
        mongoTemplate.remove(entity);
    }

    @Override
    public void deleteById(String id, Class<T> entityClass) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(id));

        mongoTemplate.remove(query, entityClass);
    }

    @Override
    public T selectById(String id, Class<T> entityClass) {
        return mongoTemplate.findById(id, entityClass);
    }

    @Override
    public List<T> selectByIds(List<String> ids, Class<T> entityClass) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").in(ids));
        return mongoTemplate.find(query, entityClass);
    }

    @Override
    public List<T> selectByConditions(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query, entityClass);
    }

    @Override
    public List<T> selectAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

    @Override
    public long selectTotalCount(Query query, Class<T> entityClass) {
        return mongoTemplate.count(query, entityClass);
    }

}
