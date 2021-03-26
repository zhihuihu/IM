/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.mongo.dao.impl;

import com.huzhihui.im.mongo.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:30 huzhi Exp $$
 */
@Repository
public class UserMongoDaoImpl extends BaseMongoDaoImpl<User> {

    /**
     *
     * @param userName
     * @return
     */
    public User selectByUserName(String userName){
        Query query = new Query(Criteria.where("userName").is(userName));
        return this.mongoTemplate.findOne(query,User.class);
    }
}
