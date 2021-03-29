/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.message.constant;

/**
 * 剔除通道连接常量配置类
 * @author huzhi
 * @version $ v 0.1 2021/3/27 20:26 huzhi Exp $$
 */
public class KickOutMessageConstant {

    /** 交换机 */
    public static final String EXCHANGE_NAME = "im.kickOutMessageExchange";
    /** 队列名称 */
    public static final String QUEUE_NAME = "im.kickOutMessageQueue";
    /** 路由键值 */
    public static final String QUEUE_ROUTE_KEY = QUEUE_NAME;
    /** 生产者名称 */
    public static final String PRODUCER_NAME = "kickOutMessageProducer";


}
