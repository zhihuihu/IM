/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.kit;

import com.huzhihui.im.common.properties.ZkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 21:09 huzhi Exp $$
 */
@Component
public class ZkKitCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ZkKit zkKit;
    @Autowired
    private ZkProperties zkProperties;

    @Override
    public void run(String... args) throws Exception {
        Thread thread = new Thread(new RegistryZkRunnable(zkKit,zkProperties));
        thread.setName("registry-zk");
        thread.start() ;
    }
}
