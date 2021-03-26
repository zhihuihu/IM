/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.kit;

import com.huzhihui.im.common.properties.ImServerProperties;
import com.huzhihui.im.common.properties.ZkProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 注册自己到ZK
 * @author huzhi
 * @version $ v 0.1 2021/3/22 20:57 huzhi Exp $$
 */
public class RegistryZkRunnable implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(RegistryZkRunnable.class);

    private ZkKit zkKit;

    private ZkProperties zkProperties;

    public RegistryZkRunnable(ZkKit zkKit, ZkProperties zkProperties) {
        this.zkKit = zkKit;
        this.zkProperties = zkProperties;
    }

    @Override
    public void run() {
        //注册监听服务
        zkKit.subscribeEvent(zkProperties.getRoot());
    }
}
