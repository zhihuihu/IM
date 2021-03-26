/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.service.impl;

import com.huzhihui.im.common.utils.IdWorkerUtils;
import com.huzhihui.im.mongo.dao.impl.UserMongoDaoImpl;
import com.huzhihui.im.mongo.entity.User;
import com.huzhihui.im.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:31 huzhi Exp $$
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMongoDaoImpl userMongoDao;

    @Override
    public void add(User user) {
        user.setId(IdWorkerUtils.getId());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMongoDao.insert(user);
    }

    @Override
    public User getByUserName(String userName) {
        return userMongoDao.selectByUserName(userName);
    }
}
