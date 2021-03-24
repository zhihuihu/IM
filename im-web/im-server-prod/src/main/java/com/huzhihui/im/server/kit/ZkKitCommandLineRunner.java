/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.kit;

import com.huzhihui.im.common.properties.ImServerProperties;
import com.huzhihui.im.common.properties.ZkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 21:09 huzhi Exp $$
 */
@Component
public class ZkKitCommandLineRunner implements CommandLineRunner {

    @Value("${server.port}")
    private int httpPort;
    @Autowired
    private ZkKit zkKit;
    @Autowired
    private ZkProperties zkProperties;
    @Autowired
    private ImServerProperties imServerProperties;

    @Override
    public void run(String... args) throws Exception {
        Thread thread = new Thread(new RegistryZkRunnable(zkKit,zkProperties,imServerProperties,httpPort));
        thread.setName("registry-zk");
        thread.start() ;
    }
}
