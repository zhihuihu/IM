/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.controller;

import com.huzhihui.im.common.utils.ResponseMessage;
import com.huzhihui.im.handler.RedisHandler;
import com.huzhihui.im.mongo.entity.User;
import com.huzhihui.im.route.algorithm.inter.RouteHandle;
import com.huzhihui.im.route.cache.ServerCache;
import com.huzhihui.im.route.dto.req.LoginReq;
import com.huzhihui.im.route.dto.res.LoginRes;
import com.huzhihui.im.service.inter.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:47 huzhi Exp $$
 */
@RestController
public class RouteController {

    @Autowired
    private RouteHandle routeHandle;
    @Autowired
    private ServerCache serverCache;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisHandler redisHandler;

    /**
     * 注册账号
     * @param userName
     * @param userCname
     * @param password
     * @return
     */
    @RequestMapping(value = "register")
    public ResponseMessage register(String userName,String userCname,String password){
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            return ResponseMessage.failure("参数异常");
        }
        User userCheck = userService.getByUserName(userName);
        if(null != userCheck){
            return ResponseMessage.failure("该用户名已存在");
        }
        User user = new User();
        user.setUserName(userName);
        user.setUserCname(userCname);
        user.setPassword(password);
        userService.add(user);
        return ResponseMessage.success();
    }

    /**
     * 登录获取Token和tcp地址
     * @param loginReq
     * @return
     */
    @RequestMapping(value = "login")
    public ResponseMessage login(@RequestBody LoginReq loginReq){

        User user = userService.getByUserName(loginReq.getUserName());
        if(null == user){
            return ResponseMessage.failure("用户或密码错误");
        }
        if(StringUtils.isEmpty(loginReq.getPassword()) || !loginReq.getPassword().equals(user.getPassword())){
            return ResponseMessage.failure("用户或密码错误");
        }
        String server = routeHandle.routeServer(serverCache.getServerList(),user.getId());
        String token = UUID.randomUUID().toString().replace("-","");
        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        loginRes.setServer(server);
        // 保存信息到redis
        return ResponseMessage.success(loginRes);
    }
}
