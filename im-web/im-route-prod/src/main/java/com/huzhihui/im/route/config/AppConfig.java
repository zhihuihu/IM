/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.config;

import com.huzhihui.im.common.properties.ImServerProperties;
import com.huzhihui.im.common.properties.ZkProperties;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:16 huzhi Exp $$
 */
@Configuration
public class AppConfig {

    /**
     * zk配置属性
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "im.zk")
    public ZkProperties zkProperties(){
        return new ZkProperties();
    }

    /**
     * im服务端口信息
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "im.server")
    public ImServerProperties imServerProperties(){
        return new ImServerProperties();
    }

    /**
     * zk客户端
     * @param zkProperties
     * @return
     */
    @Bean
    public ZkClient zkClient(ZkProperties zkProperties){
        return new ZkClient(zkProperties.getAddr(),zkProperties.getConnectTimeout());
    }
}
