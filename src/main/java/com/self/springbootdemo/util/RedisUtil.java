package com.self.springbootdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * @author zp
 */
@Component
public final class RedisUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * RedisTemplate
     */
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    public RedisUtil(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /*==============================Common==============================*/

    /**
     * 指定缓存过期时间
     * @param key 键
     * @param time 过期时间(秒)
     */
    public void expire(String key, long time){
        try {
            if(time > 0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    /**
     * 根据key获取过期时间
     * @param key 键,不能为null
     * @return 过期时间(秒),返回0表示永久有效
     */
    @SuppressWarnings("all")
    public long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true--存在,false--不存在
     */
    @SuppressWarnings("all")
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个或多个值
     */
    @SuppressWarnings("all")
    public void del(String... key){
        if(key != null && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /*==============================String==============================*/

    /**
     * 字符串缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 保存字符串缓存
     * @param key 键
     * @param value 值
     * @return true--成功,false--失败
     */
    public boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存字符串缓存并设置过期时间
     * @param key 键
     * @param value 值
     * @param time 过期时间(秒),如果time小于或等于0,缓存永远有效
     * @return true--成功,false--失败
     */
    public boolean set(String key, Object value, long time){
        try {
            if(time > 0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else{
                set(key, value);
            }

            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 缓存值递增
     * @param key 键
     * @param delta 递增数(大于0)
     * @return long
     */
    @SuppressWarnings("all")
    public long incr(String key, long delta){
        if(delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }

        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 缓存值递减
     * @param key 键
     * @param delta 递减数(大于0)
     * @return long
     */
    @SuppressWarnings("all")
    public long decr(String key, long delta){
        if(delta < 0){
            throw new RuntimeException("递减因子必须大于0");
        }

        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /*==============================Hash==============================*/

    /**
     * 获取hash
     * @param key 键,不能为null
     * @param item 项,不能为null
     * @return hash指定项的值
     */
    public Object hget(String key, String item){
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     * @param key 键
     * @return 对应键值
     */
    public Map<Object, Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 保存hash
     * @param key 键
     * @param map 对应键值
     * @return true--成功,false--失败
     */
    public boolean hmset(String key, Map<String, Object> map){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存hash并设置过期时间
     * @param key 键
     * @param map 对应键值
     * @param time 过期时间(秒)
     * @return true--成功,false--失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if(time > 0){
                expire(key, time);
            }

            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 将数据保存到hash,如果hash不存在则创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true--成功,false--失败
     */
    public boolean hset(String key, String item, Object value){
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 将数据保存到hash并设置过期时间,如果hash不存在则创建
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 过期时间(秒),如果已存在的hash表已经设置了过期时间,这里将会替换原有的时间
     * @return true--成功,false--失败
     */
    public boolean hset(String key, String item, Object value, long time){
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if(time > 0){
                expire(key, time);
            }

            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除hash中的项
     * @param key 键,不能为null
     * @param item 项,可以是多个,不能为null
     * @return 成功删除项的数量
     */
    public long hdel(String key, Object... item){
        return redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash是否包含指定项
     * @param key 键,不能为null
     * @param item 项,不能为null
     * @return true--存在,false--不存在
     */
    public boolean hHasKey(String key, String item){
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增,如果hash不存在则创建hash并返回新增后的值
     * @param key 键
     * @param item 项
     * @param delta 新增值(大于0)
     * @return double
     */
    public double hincr(String key, String item, double delta){
        return redisTemplate.opsForHash().increment(key, item, delta);
    }

    /**
     * hash递减,如果hash不存在则创建hash并返回递减后的值
     * @param key 键
     * @param item 项
     * @param delta 减少值(大于0)
     * @return double
     */
    public double hdecr(String key, String item, double delta){
        return redisTemplate.opsForHash().increment(key, item, -delta);
    }

    /*==============================Set==============================*/

    /**
     * 根据key获取set中的值
     * @param key 键
     * @return Set
     */
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 根据key判断set中是否存在对应的value
     * @param key 键
     * @param value 值
     * @return true--存在,false--不存在
     */
    @SuppressWarnings("all")
    public boolean sHasKey(String key, Object value){
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存set到缓存
     * @param key 键
     * @param values 值,可以是多个
     * @return 保存成功数
     */
    @SuppressWarnings("all")
    public long sSet(String key, Object... values){
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 保存set到缓存并设置过期时间
     * @param key 键
     * @param time 过期时间(秒)
     * @param values 值,可以是多个
     * @return 保存成功数
     */
    @SuppressWarnings("all")
    public long sSetAndTime(String key, long time, Object... values){
        try {
            long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0){
                expire(key, time);
            }

            return count;
        } catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     * @param key 键
     * @return 缓存长度
     */
    @SuppressWarnings("all")
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 删除set中指定值的元素
     * @param key 键
     * @param values 值,可以是多个
     * @return 删除数量
     */
    @SuppressWarnings("all")
    public long setRemove(String key, Object... values){
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    /*==============================List==============================*/

    /**
     * 获取list缓存内容
     * 索引位置0到-1代表获取全部元素
     * @param key 键
     * @param start 开始位置
     * @param end 结束位置
     * @return list
     */
    public List<Object> lGet(String key, long start, long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 获取list缓存的长度
     * @param key 键
     * @return 缓存长度
     */
    @SuppressWarnings("all")
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    /**
     * 通过索引获取list中的元素值
     * 索引index>=0时,0--表头,1--第二个元素,依次类推。index<0时,-1--表尾,-2--倒数第二个元素,依次类推。
     * @param key 键
     * @param index 索引
     * @return Object
     */
    public Object lGetIndex(String key, long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e){
            logger.error(e.getMessage());
            return new Object();
        }
    }

    /**
     * 保存list缓存
     * @param key 键
     * @param value 值
     * @return true--保存成功,false--保存失败
     */
    public boolean lSet(String key, Object value){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存list缓存并设置过期时间
     * @param key 键
     * @param value 值
     * @param time 过期时间(秒)
     * @return true--保存成功,false--保存失败
     */
    public boolean lSet(String key, Object value, long time){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if(time > 0){
                expire(key, time);
            }

            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存list缓存
     * @param key 键
     * @param value 值列表
     * @return true--保存成功,false--保存失败
     */
    public boolean lSet(String key, List<Object> value){
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存list缓存并设置过期时间
     * @param key 键
     * @param value 值
     * @param time 过期时间(秒)
     * @return true--保存成功,false--保存失败
     */
    public boolean lSet(String key, List<Object> value, long time){
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if(time > 0){
                expire(key, time);
            }

            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 根据索引位置修改list中的某个元素
     * @param key 键
     * @param index 索引
     * @param value 值
     * @return true--修改成功,false--修改失败
     */
    public boolean lUpdateIndex(String key, long index, Object value){
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除list中指定个数的指定值
     * @param key 键
     * @param count 删除个数
     * @param value 指定值
     * @return 删除个数
     */
    @SuppressWarnings("all")
    public long lRemove(String key, long count, Object value){
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

}
