/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.controller;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.common.constant.RedisConstant;
import com.huzhihui.im.common.dto.ImUserInfo;
import com.huzhihui.im.common.dto.msg.P2pImMessage;
import com.huzhihui.im.common.enums.MessageTypeEnum;
import com.huzhihui.im.common.utils.ResponseMessage;
import com.huzhihui.im.message.dto.SendMessage;
import com.huzhihui.im.mongo.entity.User;
import com.huzhihui.im.route.algorithm.inter.RouteHandle;
import com.huzhihui.im.route.cache.ServerCache;
import com.huzhihui.im.route.dto.req.LoginReq;
import com.huzhihui.im.route.dto.res.LoginRes;
import com.huzhihui.im.route.handler.MqMessageHandler;
import com.huzhihui.im.route.handler.RedisHandler;
import com.huzhihui.im.service.inter.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private MqMessageHandler mqMessageHandler;

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
        String oldToken = redisHandler.getHashValue(RedisConstant.TOKEN_PRE,user.getId());
        if(StringUtils.isNotEmpty(oldToken)){
            // 清除以前的token并发送给IM服务器强制离线消息
            redisHandler.removeHash(RedisConstant.TOKEN_PRE,user.getId());
            redisHandler.remove(RedisConstant.USER_PRE+oldToken);
        }
        String server = routeHandle.routeServer(serverCache.getServerList(),user.getId());
        String token = UUID.randomUUID().toString().replace("-","");
        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        loginRes.setServer(server);
        // 保存信息到redis
        ImUserInfo imUserInfo = new ImUserInfo();
        imUserInfo.setUserId(user.getId());
        imUserInfo.setUserName(user.getUserName());
        imUserInfo.setUserCname(user.getUserCname());
        imUserInfo.setServer(server);
        redisHandler.cacheHashValue(RedisConstant.TOKEN_PRE,user.getId(),token);
        redisHandler.cacheValue(RedisConstant.USER_PRE+token, JSON.toJSONString(imUserInfo));
        return ResponseMessage.success(loginRes);
    }

    /**
     * 发送单聊消息
     * @param toUserId
     * @param message
     * @return
     */
    @GetMapping(value = "sendP2pMessage")
    public ResponseMessage sendP2pMessage(String toUserId,String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setToUserId(toUserId);
        sendMessage.setMessageType(MessageTypeEnum.P2P.getCode());
        P2pImMessage p2pImMessage = new P2pImMessage();
        p2pImMessage.setData(message);
        p2pImMessage.setFromUserId("");
        p2pImMessage.setToUserId(toUserId);
        sendMessage.setMessage(JSON.toJSONString(p2pImMessage));
        mqMessageHandler.sendSendMessage(sendMessage);
        return ResponseMessage.success();
    }
}
