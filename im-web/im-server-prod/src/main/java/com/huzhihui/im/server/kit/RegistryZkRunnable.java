/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.kit;

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

    private ImServerProperties imServerProperties;

    private int httpPort;

    public RegistryZkRunnable(ZkKit zkKit, ZkProperties zkProperties, ImServerProperties imServerProperties, int httpPort) {
        this.zkKit = zkKit;
        this.zkProperties = zkProperties;
        this.imServerProperties = imServerProperties;
        this.httpPort = httpPort;
    }

    @Override
    public void run() {
        zkKit.createRootNode();
        if(zkProperties.isRegister()){
            String path = zkProperties.getRoot() + "/ip-" + imServerProperties.getIp() + ":" + imServerProperties.getSocketPort() + ":" + imServerProperties.getWebsocketPort()+ ":" + httpPort;
            zkKit.createNode(path);
            log.info("registry zookeeper success, msg=[{}]", path);
        }
    }
}
