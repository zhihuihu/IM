/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.server.kit;

import com.huzhihui.im.common.properties.ZkProperties;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 21:00 huzhi Exp $$
 */
@Component
public class ZkKit {

    @Autowired
    private ZkClient zkClient;
    @Autowired
    private ZkProperties zkProperties;

    /**
     * 创建父级节点
     */
    public void createRootNode(){
        boolean exists = zkClient.exists(zkProperties.getRoot());
        if (exists){
            return;
        }

        //创建 root
        zkClient.createPersistent(zkProperties.getRoot()) ;
    }

    /**
     * 写入指定节点 临时目录
     *
     * @param path
     */
    public void createNode(String path) {
        zkClient.createEphemeral(path);
    }
}
