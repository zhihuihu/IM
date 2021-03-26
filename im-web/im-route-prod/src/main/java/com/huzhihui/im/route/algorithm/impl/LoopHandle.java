/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.route.algorithm.impl;

import com.huzhihui.im.common.enums.HttpCodeEnum;
import com.huzhihui.im.common.exception.ImException;
import com.huzhihui.im.route.algorithm.inter.RouteHandle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 14:35 huzhi Exp $$
 */
@Component
public class LoopHandle implements RouteHandle {

    private AtomicLong index = new AtomicLong();

    @Override
    public String routeServer(List<String> values, String key) {
        if (values.size() == 0) {
            throw new ImException(HttpCodeEnum.SERVER_NOT_AVAILABLE.getCode(),HttpCodeEnum.SERVER_NOT_AVAILABLE.getDesc()) ;
        }
        Long position = index.incrementAndGet() % values.size();
        if (position < 0) {
            position = 0L;
        }

        return values.get(position.intValue());
    }
}
