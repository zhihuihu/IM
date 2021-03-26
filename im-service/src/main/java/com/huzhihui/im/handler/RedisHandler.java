/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author huzhi
 * @version $ v 0.1 2021/3/26 19:42 huzhi Exp $$
 */
@Component
public class RedisHandler {

    private static final Logger log = LoggerFactory.getLogger(RedisHandler.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 设置缓存
     * @param k
     * @param v
     * @param time
     * @return
     */
    public boolean cacheValue(String k, String v, long time) {
        try{
            ValueOperations<String, String> valueOps =  redisTemplate.opsForValue();
            valueOps.set(k, v);
            if (time > 0) {
                redisTemplate.expire(k, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception ex){
            log.error("缓存[" + k + "]失败, value[" + v + "], time[" + time + "]", ex);
        }
        return false;
    }

    /**
     * 设置Hash值
     * @param key
     * @param field
     * @param v
     * @param time
     * @return
     */
    public boolean cacheHashValue(String key,String field, String v, long time) {
        try{
            redisTemplate.opsForHash().put(key,field,v);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception ex){
            log.error("缓存[" + key + "]失败, value[" + v + "], time[" + time + "]", ex);
        }
        return false;
    }

    /**
     * 设置缓存
     * @param k
     * @param v
     * @return
     */
    public boolean cacheValue(String k, String v) {
        return cacheValue(k, v, -1);
    }

    /**
     *
     * @param key
     * @param field
     * @param v
     * @return
     */
    public boolean cacheHashValue(String key,String field, String v) {
        return cacheHashValue(key,field, v, -1);
    }

    /**
     * 获取缓存
     * @param k
     * @return
     */
    public String getValue(String k) {
        try {
            ValueOperations<String, String> valueOps =  redisTemplate.opsForValue();
            return valueOps.get( k);
        } catch (Throwable t) {
            log.error("获取缓存失败key[" + k +"]",t);
        }
        return null;
    }

    /**
     * 获取
     * @param key
     * @param field
     * @return
     */
    public String getHashValue(String key, String field) {
        try {
            return (String) redisTemplate.opsForHash().get(key,field);
        } catch (Throwable t) {
            log.error("获取缓存失败key[" + key +"]",t);
        }
        return null;
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public Map<String,String> getHashValue(String key) {
        try {
            return redisTemplate.execute((RedisCallback<Map<String, String>>) con -> {
                Map<byte[], byte[]> result = con.hGetAll(key.getBytes());
                if (CollectionUtils.isEmpty(result)) {
                    return new HashMap<>(0);
                }

                Map<String, String> ans = new HashMap<>(result.size());
                for (Map.Entry<byte[], byte[]> entry : result.entrySet()) {
                    ans.put(new String(entry.getKey()), new String(entry.getValue()));
                }
                return ans;
            });
        } catch (Throwable t) {
            log.error("获取缓存失败key[" + key +"]",t);
        }
        return null;
    }

    public boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t) {
            log.error("移除缓存失败key[" + key +"]",t);
        }
        return false;
    }

    public boolean removeHash(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t) {
            log.error("移除缓存失败key[" + key +"]",t);
        }
        return false;
    }

    public boolean removeHash(String key,String field) {
        try {
            redisTemplate.opsForHash().delete(key,field);
            return true;
        } catch (Throwable t) {
            log.error("移除缓存失败key[" + key +"]",t);
        }
        return false;
    }

    /**
     * 模糊匹配前缀相同的key值
     * @param keyPre
     * @return
     */
    public List<String> getPatternPreKeys(String keyPre){
        List<String> keys = new ArrayList<>();
        Set<String> keySet = redisTemplate.keys(keyPre + "*");
        if(!CollectionUtils.isEmpty(keySet)){
            keys = new ArrayList<>(keySet);
        }
        return keys;
    }

}
