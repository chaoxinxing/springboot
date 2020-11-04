package com.ceb.ymz.service;

import com.ceb.ymz.bean.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author fseve
 * @Date 2020/11/3 10:39
 * @Version 1.0
 **/
//service
public interface UserService {

    public void register(User user);
    public User login(User user);
    public Boolean existPhone(User user);
    public Boolean existPassword(User user);
}
