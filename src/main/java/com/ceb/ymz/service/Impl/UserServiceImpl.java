package com.ceb.ymz.service.Impl;

import com.ceb.ymz.bean.User;
import com.ceb.ymz.dao.RedisDao;
import com.ceb.ymz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author fseve
 * @Date 2020/11/3 10:39
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisDao redisDao;

    @Override
    public void register(User user) {
        redisDao.insertUser(user);
    }

    @Override
    public User login(User user) {
        String key = user.getPhone();
        if(existPhone(user)){
            if(existPassword(user)){
                user.setName(redisDao.hashExists(key,"name"));
                return user;
            }else
                return null;
        }else
            return null;
    }

    @Override
    public Boolean existPhone(User user) {
        String phone = user.getPhone();
        return redisDao.hasKey(phone);
    }

    @Override
    public Boolean existPassword(User user) {
        String phone = user.getPhone();
        String password = user.getPassword();
        return redisDao.hashExists(phone,"password").equals(password);
    }
}
