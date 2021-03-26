/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.controller;

import com.huzhihui.im.common.utils.ResponseMessage;
import com.huzhihui.im.route.algorithm.inter.RouteHandle;
import com.huzhihui.im.route.cache.ServerCache;
import com.huzhihui.im.route.dto.req.LoginReq;
import com.huzhihui.im.route.dto.res.LoginRes;
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

    /**
     * 登录获取Token和tcp地址
     * @param loginReq
     * @return
     */
    @RequestMapping(value = "login")
    public ResponseMessage login(@RequestBody LoginReq loginReq){
        String server = routeHandle.routeServer(serverCache.getServerList(),loginReq.getUserId());
        String token = UUID.randomUUID().toString().replace("-","");
        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        loginRes.setServer(server);
        return ResponseMessage.success(loginRes);
    }
}
