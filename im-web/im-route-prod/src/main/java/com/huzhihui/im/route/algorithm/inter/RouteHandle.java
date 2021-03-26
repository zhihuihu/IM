package com.huzhihui.im.route.algorithm.inter;

import java.util.List;

/**
 * 路由
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:34 huzhi Exp $$
 */
public interface RouteHandle {

    /**
     * 再一批服务器里进行路由
     * @param values
     * @param key
     * @return
     */
    String routeServer(List<String> values, String key) ;

}
