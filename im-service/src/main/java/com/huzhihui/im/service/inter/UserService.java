package com.huzhihui.im.service.inter;

import com.huzhihui.im.mongo.entity.User;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:31 huzhi Exp $$
 */
public interface UserService {

    void add(User user);

    /**
     *
     * @param userName
     * @return
     */
    User getByUserName(String userName);
}
