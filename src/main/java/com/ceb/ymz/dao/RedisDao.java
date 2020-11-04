package com.ceb.ymz.dao;

import com.ceb.ymz.bean.User;

import java.util.Map;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author fseve
 * @Date 2020/11/3 10:40
 * @Version 1.0
 **/

/**
 * oaihfalca
 */
public interface RedisDao {
    /**
     * 新增hashmap值
     */
    public void insertUser(User user);

    /**
     * hash:获取变量中的键值对
     * @param key
     * @return
     */
    public Map<String, String> hashGetAll(String key);

    /**
     * 给哈希表key中的指定字段的整数值加上增量increment，此处加1
     * @param key
     * @param hkey
     * @return
     */
    public Integer hashIncr(String key, String hkey);

    /**
     * 删除一个或者多个hash表字段
     * @param key
     * @param hkey
     * @return
     */
    public Integer hashdel(String key, String hkey);

    /**
     *String类型的删除 删除单个key值
     * @param key
     */
    public void delkey(String key);

    /**
     *
     * @param key
     * @param field
     * @return
     */
    public String hashExists(String key, String field);

    public Boolean hasKey(String key);
}
