/**
 * Aibton.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.huzhihui.im.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ID生成工具类
 * @author huzhihui
 * @version $: v 0.1 2017 2017/10/19 14:10 huzhihui Exp $$
 */
public class IdWorkerUtils {

    private static final IdWorker idWork = new IdWorker(16, 4);

    /**
     * 获取有序ID
     * @return
     */
    public static String getId() {
        return "80".concat(String.valueOf(idWork.nextId()));
    }
}

class IdWorker {

    protected static final Logger LOG                = LoggerFactory.getLogger(IdWorker.class);

    private long                  workerId;
    private long                  datacenterId;
    private long                  sequence           = 0L;

    private long                  workerIdBits       = 5L;
    private long                  datacenterIdBits   = 5L;
    private long                  maxWorkerId        = -1L ^ (-1L << workerIdBits);
    private long                  maxDatacenterId    = -1L ^ (-1L << datacenterIdBits);
    private long                  sequenceBits       = 12L;

    private long                  workerIdShift      = sequenceBits;
    private long                  datacenterIdShift  = sequenceBits + workerIdBits;
    private long                  timestampLeftShift = sequenceBits + workerIdBits
                                                       + datacenterIdBits;
    private long                  sequenceMask       = -1L ^ (-1L << sequenceBits);

    private long                  lastTimestamp      = -1L;

    public IdWorker(long workerId, long datacenterId) {
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String
                .format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        LOG.info(String.format(
            "worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
            timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId));
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.",
                lastTimestamp));
            throw new RuntimeException(
                String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return (timestamp << timestampLeftShift) | (datacenterId << datacenterIdShift)
               | (workerId << workerIdShift) | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
