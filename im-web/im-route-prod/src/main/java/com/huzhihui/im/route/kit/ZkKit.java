/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.kit;

import com.alibaba.fastjson.JSON;
import com.huzhihui.im.common.properties.ZkProperties;
import com.huzhihui.im.route.cache.ServerCache;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/22 21:00 huzhi Exp $$
 */
@Component
public class ZkKit {

    private static final Logger log = LoggerFactory.getLogger(ZkKit.class);

    @Autowired
    private ZkClient zkClient;
    @Autowired
    private ZkProperties zkProperties;
    @Autowired
    private ServerCache serverCache;

    /**
     * 监听事件
     *
     * @param path
     */
    public void subscribeEvent(String path) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChildren) throws Exception {
                log.info("Clear and update local cache parentPath=[{}],currentChildren=[{}]", parentPath,currentChildren.toString());
                //update local cache, delete and save.
                serverCache.updateCache(currentChildren) ;
            }
        });
    }

    /**
     * get all server node from zookeeper
     * @return
     */
    public List<String> getAllNode(){
        List<String> children = zkClient.getChildren(zkProperties.getRoot());
        log.info("Query all node =[{}] success.", JSON.toJSONString(children));
        return children;
    }
}
