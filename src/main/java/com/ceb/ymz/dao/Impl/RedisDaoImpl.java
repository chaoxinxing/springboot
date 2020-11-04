package com.ceb.ymz.dao.Impl;

import com.ceb.ymz.bean.User;
import com.ceb.ymz.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author fseve
 * @Date 2020/11/3 10:40
 * @Version 1.0
 **/
@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired
    StringRedisTemplate template;

    @Override
    public void insertUser(User user) {
        String key = user.getPhone();
        template.opsForHash().put(key,"name", user.getName());
        template.opsForHash().put(key,"phone", user.getPhone());
        template.opsForHash().put(key,"password", user.getPassword());
    }

    @Override
    public Map<String, String> hashGetAll(String key) {
        HashOperations<String, String, String> ops = template.opsForHash();
        return ops.entries(key);
    }

    @Override
    public Integer hashIncr(String key, String hkey) {
        return template.opsForHash().increment(key, hkey, 1).intValue();
    }

    @Override
    public Integer hashdel(String key, String hkey) {
        return template.opsForHash().delete(key, hkey).intValue();
    }

    @Override
    public void delkey(String key) {
        template.delete(key);
    }

    @Override
    public String hashExists(String key, String field) {
        return (String) template.opsForHash().get(key, field);
    }

    @Override
    public Boolean hasKey(String key) {
        return template.hasKey(key);
    }
}
