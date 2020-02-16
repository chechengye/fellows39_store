package com.weichuang.service.impl;

import com.weichuang.dao.UserDao;
import com.weichuang.pojo.User;
import com.weichuang.service.IUserService;

public class UserService implements IUserService {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDao();
    }
    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
