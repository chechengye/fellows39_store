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

    /**
     * 登陆操作，并返回用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        return userDao.login(username , password);
    }
}
